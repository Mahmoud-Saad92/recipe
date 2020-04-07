package eg.bazinga.recipe.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "UNIT_OF_MEASURE")
@Data
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

}
