package pizzas;

import lombok.Data;

import java.util.List;

@Data
public class Pizza {
    /* user defined pizza name */
    private String name;
    private List<Ingredient> ingredients;
}
