package thor.app;

import android.app.Application;
import android.content.Context;

import thor.app.dependencies.AppComponent;
import thor.app.dependencies.DaggerAppComponent;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initAppContext();
        initAppComponent();
        initThirdPartyLibs();
    }

    // =============================================================================================
    // CONTEXT
    // =============================================================================================

    private static Context context;

    private void initAppContext() {
        App.context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    // =============================================================================================
    // DAGGER
    // =============================================================================================

    private static AppComponent component;

    private void initAppComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder().build();
        }
    }

    public static AppComponent getComponent() {
        return component;
    }

    public static void setComponent(AppComponent component) {
        App.component = component;
    }

    public static void clearComponent() {
        App.component = null;
    }

    // =============================================================================================
    // THIRD PARTY APPS
    // =============================================================================================

    private void initThirdPartyLibs() {

    }
}
