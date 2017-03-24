package pl.allegro.braincode.integration.allegro.category;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface CategoriesService {
    @GET("/v1/allegro/categories")
    public Call<CategoryList> getCategories(@Query("access_token") String accessToken, @Query("parentCategory") String parentCategory);
}
