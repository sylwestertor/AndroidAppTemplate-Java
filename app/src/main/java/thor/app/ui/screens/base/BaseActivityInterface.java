package thor.app.ui.screens.base;

import thor.app.api.retrofit.ApiError;

public interface BaseActivityInterface {
    void showError(String message);

    void showError(ApiError apiError);
}
