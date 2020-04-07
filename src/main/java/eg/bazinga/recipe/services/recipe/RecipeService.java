package eg.bazinga.recipe.services.recipe;

import eg.bazinga.recipe.models.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAllRecipes();

    Set<Recipe> saveAllRecipes(Set<Recipe> recipes);
}
