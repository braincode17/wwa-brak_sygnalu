package pl.allegro.braincode.api.category;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.braincode.category.CategoriesRepository;
import pl.allegro.braincode.messages.category.CategoryDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoriesRepository categoriesRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoriesRepository categoriesRepository, ModelMapper modelMapper) {
        this.categoriesRepository = categoriesRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CategoryDto> getCategories(@RequestParam(required = false) Long parentId) {
        return categoriesRepository.getCategories(parentId)
                .stream()
                .map(c-> modelMapper.map(c, CategoryDto.class))
                .collect(Collectors.toList());
    }

}
