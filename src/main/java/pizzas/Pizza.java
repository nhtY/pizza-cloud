package pizzas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pizza {

    /** identity of the pizza **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt = new Date();

    /** user defined pizza name **/
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    /** Ingredients List of the pizza **/
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredients;
}
