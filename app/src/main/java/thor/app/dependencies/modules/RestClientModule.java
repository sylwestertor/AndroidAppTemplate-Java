package thor.app.dependencies.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import thor.app.api.RestClient;
import thor.app.api.RestClientImpl;
import thor.app.prefs.Prefs;

@Module
public class RestClientModule {
    @Provides
    @Singleton
    RestClient providesRestClient(Prefs prefs) {
        return new RestClientImpl(prefs);
    }
}
