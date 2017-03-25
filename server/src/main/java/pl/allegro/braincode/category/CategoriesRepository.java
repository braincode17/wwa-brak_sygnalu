package pl.allegro.braincode.category;

import org.springframework.stereotype.Service;
import pl.allegro.braincode.messages.category.Category;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoriesRepository {

    public List<Category> getCategories() {
        return Arrays.asList(Category.values());
    }

   /* private final AuthService authService;
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
    }*/

}
