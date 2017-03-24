package pl.allegro.braincode.integration.allegro.category;

import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

//    /v1/allegro/categories
public interface CategoriesService {

    @GET("/categories")
    public List<Category> getCategories(@Query("parentCategory") String parentCategory);
}
