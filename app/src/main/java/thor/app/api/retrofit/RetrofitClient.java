package thor.app.api.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import thor.app.prefs.Prefs;

public class RetrofitClient {
    public static Retrofit createRetrofit(String hostUrl, long timeout, Prefs prefs) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor(prefs))
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(hostUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static class HeaderInterceptor implements okhttp3.Interceptor {
        Prefs prefs;

        public HeaderInterceptor(Prefs prefs) {
            this.prefs = prefs;
        }

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            okhttp3.Request request = chain.request();

            if (!prefs.isToken())
                return chain.proceed(request);

            request = request.newBuilder()
                    .addHeader("Authorization", "Bearer " + prefs.getToken())
                    .build();

            return chain.proceed(request);
        }
    }

    public static <T> Callback<T> wrap(final ApiCallback<T> callback) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(new ApiError(response));
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (t instanceof TimeoutException) {
                    callback.onFailure(new ApiError.Builder().type(ApiError.Type.TIMEOUT).build());
                } else {
                    callback.onFailure(new ApiError.Builder().type(ApiError.Type.OTHER).message(t.getClass().getName() + " " + t.getMessage()).build());
                }
            }
        };
    }

    public static <T> ApiCall<T> wrap(final retrofit2.Call<T> call) {
        return new ApiCall<T>() {
            @Override
            public void send(ApiCallback<T> callback) {
                call.enqueue(wrap(callback));
            }

            @Override
            public void cancel() {
                call.cancel();
            }

            @Override
            public boolean isCanceled() {
                return call.isCanceled();
            }
        };
    }
}
