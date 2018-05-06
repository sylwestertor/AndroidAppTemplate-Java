package thor.app.ui.screens.base;

import thor.app.dependencies.DependencyPack;
import thor.app.prefs.IPrefs;

public abstract class BasePresenter<T extends BaseInterface> {
    protected T view;
    protected IPrefs prefs;

    public BasePresenter(T view, DependencyPack pack) {
        this.view = view;
        this.prefs = pack.getPrefs();
    }

    public abstract void init();
}
