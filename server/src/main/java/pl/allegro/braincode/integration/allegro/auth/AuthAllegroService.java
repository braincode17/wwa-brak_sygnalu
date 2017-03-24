package pl.allegro.braincode.integration.allegro.auth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthAllegroService {
    @FormUrlEncoded
    @POST("auth/oauth/token")
    Call<AccessToken> auth(@Field("grant_type") String grantType);
}
