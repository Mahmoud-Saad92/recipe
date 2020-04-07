package eg.bazinga.recipe.services.recipe;

import eg.bazinga.recipe.models.Recipe;
import eg.bazinga.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        log.debug("Fetching All Recipes...");

        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> saveAllRecipes(List<Recipe> recipes) {
        log.debug("Saving All Recipes...");

        return recipeRepository.saveAll(recipes);
    }
}
