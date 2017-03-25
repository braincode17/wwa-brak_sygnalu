package pl.allegro.braincode.integration.allegro.category;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoriesService {
    @GET("/v1/allegro/categories")
    public Call<CategoryList> getCategories(@Query("access_token") String accessToken, @Query("parentCategory") Long parentCategory);
}
