package pizzas.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pizzas.Ingredient;

import java.util.HashMap;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private HashMap<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("SCK",
                new Ingredient("SCK", "Sucuk", Ingredient.Type.PROTEiN));
        ingredientMap.put("SOSIS",
                new Ingredient("SOSIS", "Sosis", Ingredient.Type.PROTEiN));
        ingredientMap.put("SLM",
                new Ingredient("SLM", "Salam", Ingredient.Type.PROTEiN));
        ingredientMap.put("MZRLL",
                new Ingredient("MZRLL", "Mozerella", Ingredient.Type.CHEESE));
        ingredientMap.put("BYZ",
                new Ingredient("BYZ", "Beyaz Peynir", Ingredient.Type.CHEESE));
        ingredientMap.put("CHD",
                new Ingredient("CHD", "Cheddar Peyniri", Ingredient.Type.CHEESE));
        ingredientMap.put("MNTR",
                new Ingredient("MNTR", "Mantar", Ingredient.Type.VEGGiES));
        ingredientMap.put("ZYT",
                new Ingredient("ZYT", "Zeytin", Ingredient.Type.VEGGiES));
        ingredientMap.put("ZYT",
                new Ingredient("MSR", "Mısır", Ingredient.Type.VEGGiES));
        ingredientMap.put("SGN",
                new Ingredient("SGN", "Soğan", Ingredient.Type.VEGGiES));
        ingredientMap.put("PTL",
                new Ingredient("PTL", "Patlıcan", Ingredient.Type.VEGGiES));
    }

    @Override
    public Ingredient convert(String ingredientID) {
        return ingredientMap.get(ingredientID);
    }
}
