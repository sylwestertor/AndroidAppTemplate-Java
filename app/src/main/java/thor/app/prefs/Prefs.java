package thor.app.prefs;

public interface Prefs {
    String getToken();

    boolean isToken();

    void setToken(String token);

    void clearToken();
}
