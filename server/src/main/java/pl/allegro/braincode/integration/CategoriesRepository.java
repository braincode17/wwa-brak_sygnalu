package pl.allegro.braincode.integration;

import org.springframework.stereotype.Service;
import pl.allegro.braincode.integration.allegro.auth.AccessToken;
import pl.allegro.braincode.integration.allegro.auth.AuthService;
import pl.allegro.braincode.integration.allegro.category.CategoriesService;
import pl.allegro.braincode.integration.allegro.category.Category;
import pl.allegro.braincode.integration.allegro.category.CategoryList;
import pl.allegro.braincode.integration.allegro.category.ServiceGenerator;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

@Service
public class CategoriesRepository {

    public Call<CategoryList> getCategories(String text) {
        AuthService authService = new AuthService();
        Call<AccessToken> auth = authService.auth();
        try {
            String accessToken = auth.execute().body().getAccessToken();
            CategoriesService service = ServiceGenerator.createService(CategoriesService.class);
            return service.getCategories(accessToken, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
