package eg.bazinga.recipe.models;

import eg.bazinga.recipe.models.enums.Difficulty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RECIPE")
@Data
@EqualsAndHashCode(exclude = {"notes", "ingredients"})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    public void setNotes(Notes notes) {
        notes.setRecipe(this);
        this.notes = notes;
    }

    public Set<Ingredient> getIngredients() {
        if (ingredients == null) {
            ingredients = new HashSet<>();
        }
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.getIngredients().add(ingredient);
    }


    public Set<Category> getCategories() {
        if (categories == null) {
            categories = new HashSet<>();
        }
        return categories;
    }

}
