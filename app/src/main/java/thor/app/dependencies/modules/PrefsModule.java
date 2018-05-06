package thor.app.dependencies.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import thor.app.App;
import thor.app.prefs.IPrefs;
import thor.app.prefs.Prefs;

@Module
public class PrefsModule {
    @Provides
    @Singleton
    IPrefs providePrefs(SharedPreferences sharedPreferences, Gson gson) {
        return new Prefs(sharedPreferences, gson);
    }

    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(App.getContext().getPackageName(), Context.MODE_PRIVATE);
    }

    @Provides
    Context provideContext() {
        return App.getContext();
    }
}
