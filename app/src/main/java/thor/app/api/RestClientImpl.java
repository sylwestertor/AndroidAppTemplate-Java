package thor.app.api;

import retrofit2.Retrofit;
import thor.app.Config;
import thor.app.api.retrofit.ApiCall;
import thor.app.api.retrofit.ApiCallback;
import thor.app.api.retrofit.RetrofitClient;
import thor.app.prefs.Prefs;

public class RestClientImpl implements RestClient {
    protected Api api;
    protected Retrofit retrofit;

    public RestClientImpl(Prefs prefs) {
        this.retrofit = RetrofitClient.createRetrofit(Config.API_URL, Config.API_TIMEOUT, prefs);
        this.api = retrofit.create(Api.class);
    }

    @Override
    public ApiCall<Void> dummy(String id, ApiCallback<Void> callback) {
        ApiCall<Void> apiCall = RetrofitClient.wrap(api.dummy(id));
        apiCall.send(callback);
        return apiCall;
    }
}
