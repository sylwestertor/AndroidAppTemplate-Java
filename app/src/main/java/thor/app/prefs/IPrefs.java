package thor.app.prefs;

public interface IPrefs {
    String getToken();

    boolean isToken();

    void setToken(String token);

    void clearToken();
}
