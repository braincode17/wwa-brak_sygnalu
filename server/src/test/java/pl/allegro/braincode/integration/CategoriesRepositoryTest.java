package pl.allegro.braincode.integration;

import org.junit.Test;
import pl.allegro.braincode.category.CategoriesRepository;
import pl.allegro.braincode.integration.allegro.auth.AuthService;
import pl.allegro.braincode.integration.allegro.category.Category;

import java.util.List;

public class CategoriesRepositoryTest {

    @Test
    public void shouldGetMainCategoriesList() throws Exception {
        CategoriesRepository categoriesRepository = new CategoriesRepository(new AuthService());
        List<Category> categories = categoriesRepository.getCategories(null);
        System.out.println(categories.size());

    }

    @Test
    public void shouldGetSubCategoriesList() throws Exception {
        CategoriesRepository categoriesRepository = new CategoriesRepository(new AuthService());
        List<Category> categories = categoriesRepository.getCategories(26013L);
        System.out.println(categories.size());

    }

}