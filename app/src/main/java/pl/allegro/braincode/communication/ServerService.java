package pl.allegro.braincode.communication;

import java.util.List;
import pl.allegro.braincode.messages.price.Suggestion;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerService {

    @GET("categories")
    Call<List<String>> getCategories();

    @GET("prices")
    Call<Suggestion> getPrices(@Query("category") String category, @Query("phrase") String phrase,
                               @Query("days") Integer days);

}