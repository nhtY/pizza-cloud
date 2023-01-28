package pizzas.data;

import pizzas.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    /** To fetch all the ingredients from the database. **/
    Iterable<Ingredient> findAll();

    /**
     * To fetch a single ingredient, whose id matches the given id, from the database.
     * @param id String Ingredient id
     * @return
     */
    Optional<Ingredient> findById(String id);

    /**
     * Adds a new record into the database table.
     * @param ingredient The Ingredient whose data will be saved
     * @return saved Ingredient Object
     */
    Ingredient save(Ingredient ingredient);
}
