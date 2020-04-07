package eg.bazinga.recipe.services.category;

import eg.bazinga.recipe.models.Category;

public interface CategoryService {

    Category getCategoryByDescription(String description);
}
