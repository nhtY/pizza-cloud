package pizzas;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {

    // delivery address data
    private String deliveryName;

    private String deliveryStreet;

    private String deliveryCity;
    private String deliveryZip;

    // credit card data
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza (Pizza pizza) {
        this.pizzas.add(pizza);
    }


}
