package pl.allegro.braincode.integration;

import okhttp3.Request;
import org.junit.Test;
import pl.allegro.braincode.integration.allegro.category.Category;
import pl.allegro.braincode.integration.allegro.category.CategoryList;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

import static org.junit.Assert.*;

public class CategoriesRepositoryTest {
    @Test
    public void getCategories() throws Exception {
        CategoriesRepository categoriesRepository = new CategoriesRepository();
        Call<CategoryList> categories = categoriesRepository.getCategories("26013");
        Request request = (Request) categories.request();
        Response<CategoryList> execute = categories.execute();
        CategoryList body = execute.body();
        System.out.println(body.getCategories().size());

    }

}