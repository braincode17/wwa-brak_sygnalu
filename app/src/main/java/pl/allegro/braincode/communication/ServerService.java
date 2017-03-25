package pl.allegro.braincode.communication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerService {

    @GET("categories")
    Call<List<String>> getCategories();

}