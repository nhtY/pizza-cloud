package pizzas;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@Slf4j
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("SCK", "Sucuk", Ingredient.Type.PROTEiN),
                new Ingredient("SOSIS", "Sosis", Ingredient.Type.PROTEiN),
                new Ingredient("SLM", "Salam", Ingredient.Type.PROTEiN),
                new Ingredient("MZRLL", "Mozerella", Ingredient.Type.CHEESE),
                new Ingredient("BYZ", "Beyaz Peynir", Ingredient.Type.CHEESE),
                new Ingredient("CHD", "Cheddar Peyniri", Ingredient.Type.CHEESE),
                new Ingredient("MNTR", "Mantar", Ingredient.Type.VEGGiES),
                new Ingredient("ZYT", "Zeytin", Ingredient.Type.VEGGiES),
                new Ingredient("MSR", "Mısır", Ingredient.Type.VEGGiES),
                new Ingredient("SGN", "Soğan", Ingredient.Type.VEGGiES),
                new Ingredient("PTL", "Patlıcan", Ingredient.Type.VEGGiES)
                );

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
    public String processPizza(Pizza pizza,
                              @ModelAttribute PizzaOrder pizzaOrder) {

        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza);
        return "redirect/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type ) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
