package thor.app.api.retrofit;

public interface ApiCall<T> {
    void send(ApiCallback<T> callback);

    void cancel();

    boolean isCanceled();
}
