package thor.app.prefs;

import android.content.SharedPreferences;

import com.google.gson.Gson;

public class PrefsImpl implements Prefs {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public PrefsImpl(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    private final static String KEY_TOKEN = "__token__";

    @Override
    public String getToken() {
        return sharedPreferences.getString(KEY_TOKEN, "");
    }

    @Override
    public boolean isToken() {
        return sharedPreferences.contains(KEY_TOKEN);
    }

    @Override
    public void setToken(String token) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply();
    }

    @Override
    public void clearToken() {
        sharedPreferences.edit().remove(KEY_TOKEN).apply();
    }
}
