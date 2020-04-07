package eg.bazinga.recipe.services.recipe;

import eg.bazinga.recipe.models.Recipe;
import eg.bazinga.recipe.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> saveAllRecipes(List<Recipe> recipes) {
        return recipeRepository.saveAll(recipes);
    }
}
