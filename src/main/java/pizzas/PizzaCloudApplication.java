package pizzas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pizzas.data.IngredientRepository;

@SpringBootApplication
public class PizzaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.deleteAll();
			repo.save(new Ingredient("SCK", "Sucuk", Ingredient.Type.PROTEiN));
			repo.save(new Ingredient("SOSIS", "Sosis", Ingredient.Type.PROTEiN));
			repo.save(new Ingredient("SLM", "Salam", Ingredient.Type.PROTEiN));
			repo.save(new Ingredient("MZRLL", "Mozerella", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("BYZ", "Beyaz Peynir", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("CHD", "Cheddar Peyniri", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("MNTR", "Mantar", Ingredient.Type.VEGGiES));
			repo.save(new Ingredient("ZYTN", "Zeytin", Ingredient.Type.VEGGiES));
			repo.save(new Ingredient("MSR", "Mısır", Ingredient.Type.VEGGiES));
			repo.save(new Ingredient("SGN", "Soğan", Ingredient.Type.VEGGiES));
			repo.save(new Ingredient("PTLCN", "Patlıcan", Ingredient.Type.VEGGiES));
		};
	}
}
