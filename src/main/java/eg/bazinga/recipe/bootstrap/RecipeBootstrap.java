package eg.bazinga.recipe.bootstrap;

import eg.bazinga.recipe.models.*;
import eg.bazinga.recipe.models.enums.Difficulty;
import eg.bazinga.recipe.services.category.CategoryService;
import eg.bazinga.recipe.services.recipe.RecipeService;
import eg.bazinga.recipe.services.unitofmeasure.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryService categoryServiceImpl;
    private UnitOfMeasureService unitOfMeasureServiceImpl;
    private RecipeService recipeServiceImpl;

    @Autowired
    public RecipeBootstrap(CategoryService categoryServiceImpl,
                           UnitOfMeasureService unitOfMeasureServiceImpl,
                           RecipeService recipeServiceImpl) {

        this.categoryServiceImpl = categoryServiceImpl;
        this.unitOfMeasureServiceImpl = unitOfMeasureServiceImpl;
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeServiceImpl.saveAllRecipes(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(1);

        UnitOfMeasure eachUnitOfMeasure = unitOfMeasureServiceImpl.getUnitOfMeasureByDescription("Each");
        UnitOfMeasure tablespoonUnitOfMeasure = unitOfMeasureServiceImpl.getUnitOfMeasureByDescription("Tablespoon");
        UnitOfMeasure teaspoonUnitOfMeasure = unitOfMeasureServiceImpl.getUnitOfMeasureByDescription("Teaspoon");
        UnitOfMeasure dashUnitOfMeasure = unitOfMeasureServiceImpl.getUnitOfMeasureByDescription("Dash");
        UnitOfMeasure cupUnitOfMeasure = unitOfMeasureServiceImpl.getUnitOfMeasureByDescription("Cup");
        UnitOfMeasure pintUnitOfMeasure = unitOfMeasureServiceImpl.getUnitOfMeasureByDescription("Pint");

        Category americanCategory = categoryServiceImpl.getCategoryByDescription("American");
        Category mexicanCategory = categoryServiceImpl.getCategoryByDescription("Mexican");

        Recipe guacRecipe = new Recipe();

        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.Easy);
        guacRecipe.setDirections("");

        guacRecipe.addCategory(americanCategory);
        guacRecipe.addCategory(mexicanCategory);

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("");

        guacRecipe.setNotes(guacNotes);

        setIngredients(guacRecipe, "", new BigDecimal(2), eachUnitOfMeasure);
        setIngredients(guacRecipe, "", new BigDecimal(".5"), teaspoonUnitOfMeasure);
        setIngredients(guacRecipe, "", new BigDecimal(2), tablespoonUnitOfMeasure);
        setIngredients(guacRecipe, "", new BigDecimal(2), tablespoonUnitOfMeasure);
        setIngredients(guacRecipe, "", new BigDecimal(2), eachUnitOfMeasure);
        setIngredients(guacRecipe, "", new BigDecimal(2), tablespoonUnitOfMeasure);
        setIngredients(guacRecipe, "", new BigDecimal(2), dashUnitOfMeasure);
        setIngredients(guacRecipe, "", new BigDecimal(".5"), eachUnitOfMeasure);

        recipes.add(guacRecipe);

        return recipes;
    }

    private void setIngredients(Recipe recipe, String description, BigDecimal amount, UnitOfMeasure uom) {
        recipe.addIngredient(new Ingredient(description, amount, uom));
    }
}
