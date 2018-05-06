package thor.app.ui.screens.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import thor.app.dependencies.DependencyPack;

public abstract class BaseActivity<T extends BasePresenter>
        extends AppCompatActivity
        implements BaseInterface {

    protected Activity activity;
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;

        Integer layout = createLayout();
        if(layout != null) {
            setContentView(layout);
            ButterKnife.bind(this);
        }

        DependencyPack pack = new DependencyPack();
        presenter = createPresenter(pack);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @LayoutRes
    protected abstract Integer createLayout();

    @NonNull
    protected abstract T createPresenter(DependencyPack pack);

    @Override
    public void showError(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
