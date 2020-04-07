package eg.bazinga.recipe.controllers;

import eg.bazinga.recipe.services.recipe.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/recipe")
@Slf4j
public class RecipeController {

    private RecipeService recipeServiceImpl;

    @Autowired
    public RecipeController(RecipeService recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public String getRecipes(Model model) {
        log.debug("Request for recipe page received..");
        model.addAttribute("recipes", recipeServiceImpl.getAllRecipes());

        return "recipe";
    }
}
