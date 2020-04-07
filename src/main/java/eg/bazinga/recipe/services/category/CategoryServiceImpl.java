package eg.bazinga.recipe.services.category;

import eg.bazinga.recipe.models.Category;
import eg.bazinga.recipe.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryByDescription(String description) {

        Category category;
        Optional<Category> optionalCategory = categoryRepository.findByDescription(description);

        if (optionalCategory.isPresent()){
            category = optionalCategory.get();
        } else {
            throw new RuntimeException("Expected Category Not Found");
        }

        return category;
    }
}
