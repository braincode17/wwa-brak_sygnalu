package pl.allegro.braincode.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegro.braincode.integration.allegro.auth.AuthService;
import pl.allegro.braincode.integration.allegro.auth.ServiceGenerator;
import pl.allegro.braincode.integration.allegro.category.CategoriesService;
import pl.allegro.braincode.integration.allegro.category.Category;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
public class CategoriesRepository {

    private final AuthService authService;
    private CategoriesService service = ServiceGenerator.createService(CategoriesService.class);

    @Autowired
    public CategoriesRepository(AuthService authService) {
        this.authService = authService;
    }

    public List<Category> getCategories(Long parentCategoryId) {
        try {
            return service
                    .getCategories(authService.auth().getAccessToken(), parentCategoryId)
                    .execute()
                    .body()
                    .getCategories();
        } catch (IOException e) {
            throw new RuntimeException("Error during getting categories", e);
        }
    }

}
