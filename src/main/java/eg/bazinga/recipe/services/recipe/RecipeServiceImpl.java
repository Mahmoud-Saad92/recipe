package eg.bazinga.recipe.services.recipe;

import eg.bazinga.recipe.models.Recipe;
import eg.bazinga.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        log.debug("Fetching All Recipes...");

        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

        return recipes;
    }

    @Override
    public Set<Recipe> saveAllRecipes(Set<Recipe> recipes) {
        log.debug("Saving All Recipes...");

        Set<Recipe> savedRecipes = new HashSet<>();
        recipeRepository.saveAll(recipes).iterator().forEachRemaining(savedRecipes::add);

        return savedRecipes;
    }
}
