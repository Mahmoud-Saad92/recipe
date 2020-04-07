package eg.bazinga.recipe.services.recipe;

import eg.bazinga.recipe.models.Recipe;
import eg.bazinga.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeServiceImplTest {

    private RecipeService recipeServiceImpl;
    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getAllRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> set = new HashSet<>();
        set.add(recipe);

        Mockito.when(recipeServiceImpl.getAllRecipes()).thenReturn(set);

        Set<Recipe> recipes = recipeServiceImpl.getAllRecipes();

        assertEquals(1, recipes.size());

        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}