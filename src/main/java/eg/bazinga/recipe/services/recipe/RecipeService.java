package eg.bazinga.recipe.services.recipe;

import eg.bazinga.recipe.models.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    List<Recipe> saveAllRecipes(List<Recipe> recipes);
}
