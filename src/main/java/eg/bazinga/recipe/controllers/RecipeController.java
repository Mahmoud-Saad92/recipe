package eg.bazinga.recipe.controllers;

import eg.bazinga.recipe.services.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/recipe")
public class RecipeController {

    private RecipeService recipeServiceImpl;

    @Autowired
    public RecipeController(RecipeService recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public String getRecipes(Model model) {

        model.addAttribute("recipes", recipeServiceImpl.getAllRecipes());

        return "recipe";
    }
}
