package thor.app.api;

import thor.app.api.retrofit.ApiCall;
import thor.app.api.retrofit.ApiCallback;

public interface RestClient {
    ApiCall<Void> dummy(String id, ApiCallback<Void> callback);
}
