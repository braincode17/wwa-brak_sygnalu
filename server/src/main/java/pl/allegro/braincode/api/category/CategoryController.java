package pl.allegro.braincode.api.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.braincode.messages.category.Category;
import pl.allegro.braincode.category.CategoriesRepository;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoryController(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoriesRepository.getCategories();
    }

}
