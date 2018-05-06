package thor.app.dependencies;


import javax.inject.Singleton;

import dagger.Component;
import thor.app.dependencies.modules.PrefsModule;

@Singleton
@Component(modules = {
        PrefsModule.class
})
public interface AppComponent {
    void inject(DependencyPack pack);
}
