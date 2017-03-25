package pl.allegro.braincode.communication;

import java.util.List;
import pl.allegro.braincode.messages.category.Category;
import pl.allegro.braincode.messages.price.Suggestion;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerService {

    @GET("categories")
    Call<List<String>> getCategories();

    @GET("prices")
    Call<Suggestion> getPrices(@Query("category") Category category, @Query("phrase") String phrase);

}