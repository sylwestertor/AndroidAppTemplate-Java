package thor.app.ui.screens.base;

import thor.app.dependencies.DependencyPack;
import thor.app.prefs.Prefs;

public abstract class BasePresenter<T extends BaseActivityInterface> {
    protected T view;
    protected Prefs prefs;

    public BasePresenter(T view, DependencyPack pack) {
        this.view = view;
        this.prefs = pack.getPrefs();
    }

    public abstract void init();
}
