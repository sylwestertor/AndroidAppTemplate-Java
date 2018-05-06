package thor.app.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

public interface Api {

    @GET("dummy/{id}")
    Call<Void> dummy(@Path("id") String id);

}
