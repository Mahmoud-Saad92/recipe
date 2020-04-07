package eg.bazinga.recipe.controllers;

import eg.bazinga.recipe.models.Recipe;
import eg.bazinga.recipe.services.recipe.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeControllerTest {

    private RecipeController recipeController;

    @Mock
    private RecipeService recipeServiceImpl;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeController = new RecipeController(recipeServiceImpl);
    }

    @Test
    void getRecipes() {

        //given
        Recipe recipeOne = new Recipe();
        recipeOne.setId(1l);

        Recipe recipeTwo = new Recipe();
        recipeTwo.setId(2l);

        HashSet<Recipe> recipes = new HashSet<>();
        recipes.add(recipeOne);
        recipes.add(recipeTwo);

        Mockito.when(recipeServiceImpl.getAllRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // when
        String page = recipeController.getRecipes(model);

        // then
        assertEquals("recipe", page);
        Mockito.verify(recipeServiceImpl, Mockito.times(1)).getAllRecipes();
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
        assertEquals(2,argumentCaptor.getValue().size());

    }
}