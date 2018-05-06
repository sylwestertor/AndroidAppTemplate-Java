package thor.app.api.retrofit;

import thor.app.api.retrofit.ApiError;

public interface ApiCallback<T> {
    void onSuccess(T object);

    void onFailure(ApiError error);
}
