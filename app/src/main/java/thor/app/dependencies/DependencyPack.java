package thor.app.dependencies;

import javax.inject.Inject;

import thor.app.App;
import thor.app.prefs.IPrefs;

public class DependencyPack {
    @Inject
    IPrefs prefs;

    public DependencyPack() {
        App.getComponent().inject(this);
    }

    public IPrefs getPrefs() {
        return prefs;
    }
}
