package thor.app.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import thor.app.dependencies.modules.PrefsModule;
import thor.app.dependencies.modules.RestClientModule;

@Singleton
@Component(modules = {
        PrefsModule.class,
        RestClientModule.class
})
public interface AppComponent {
    void inject(DependencyPack pack);
}
