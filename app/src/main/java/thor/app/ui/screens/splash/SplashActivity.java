package thor.app.ui.screens.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import thor.app.R;
import thor.app.dependencies.DependencyPack;
import thor.app.ui.screens.base.BaseActivity;

public class SplashActivity
        extends BaseActivity<SplashPresenter>
        implements SplashActivityInterface {

    @Override
    protected Integer createLayout() {
        return R.layout.activity_splash;
    }

    @NonNull
    @Override
    protected SplashPresenter createPresenter(DependencyPack pack) {
        return new SplashPresenter(this, pack);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.init();
    }
}
