package pizzas.data;

import pizzas.PizzaOrder;

public interface OrderRepository {
    /**
     * Insert a new PizzaOrder into the database.
     * @param order PizzaOrder
     * @return saved PizzaOrder
     */
    PizzaOrder save(PizzaOrder order);

}
