package pl.allegro.braincode.communication;

import pl.allegro.braincode.communication.messages.BaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerService {

    @GET("offers")
    Call<BaseResponse> getOffer(@Query("id") String id);

}