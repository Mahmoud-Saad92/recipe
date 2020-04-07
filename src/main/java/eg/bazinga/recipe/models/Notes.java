package eg.bazinga.recipe.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "NOTES")
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String recipeNotes;
    @OneToOne
    private Recipe recipe;
}
