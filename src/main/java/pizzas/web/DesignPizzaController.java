package pizzas.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pizzas.Ingredient;
import pizzas.Pizza;
import pizzas.PizzaOrder;
import pizzas.data.IngredientRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/design")
@Slf4j
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {

    private IngredientRepository ingredientRepo;

    public DesignPizzaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();

        Ingredient.Type[] types = Ingredient.Type.values();
        for (val type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "pizzaOrder")
    public PizzaOrder order() {
        return new PizzaOrder();
    }

    @ModelAttribute(name = "pizza")
    public Pizza pizza() {
        return new Pizza();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processPizza(@Valid Pizza pizza, Errors errors,
                              @ModelAttribute PizzaOrder pizzaOrder) {

        if(errors.hasErrors()) {
            return "design"; // same page
        }

        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza);
        log.info("Pizzas: {}" , pizzaOrder.getPizzas());
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Ingredient.Type type ) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
