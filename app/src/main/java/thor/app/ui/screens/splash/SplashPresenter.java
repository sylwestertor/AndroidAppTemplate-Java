package thor.app.ui.screens.splash;

import thor.app.api.RestClient;
import thor.app.api.retrofit.ApiCallback;
import thor.app.api.retrofit.ApiError;
import thor.app.dependencies.DependencyPack;
import thor.app.ui.screens.base.BasePresenter;

public class SplashPresenter extends BasePresenter<SplashActivityInterface> {
    RestClient restClient;

    public SplashPresenter(SplashActivityInterface view, DependencyPack pack) {
        super(view, pack);
        restClient = pack.getRestClient();
    }

    @Override
    public void init() {
        restClient.dummy("dummy", new ApiCallback<Void>() {
            @Override
            public void onSuccess(Void object) {

            }

            @Override
            public void onFailure(ApiError error) {

            }
        });
    }
}
