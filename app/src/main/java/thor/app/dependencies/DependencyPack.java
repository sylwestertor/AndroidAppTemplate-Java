package thor.app.dependencies;

import javax.inject.Inject;

import thor.app.App;
import thor.app.api.RestClient;
import thor.app.prefs.Prefs;

public class DependencyPack {
    @Inject
    Prefs prefs;
    @Inject
    RestClient restClient;

    public DependencyPack() {
        App.getComponent().inject(this);
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public RestClient getRestClient() {
        return restClient;
    }
}
