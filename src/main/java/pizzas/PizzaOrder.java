package pizzas;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {

    // delivery address data
    @NotBlank(message = "Teslim alacak kişinin adı gereklidir")
    private String deliveryName;

    @NotBlank(message = "Cadde-Sokak bilgisi gereklidir")
    private String deliveryStreet;

    @NotBlank(message = "Şehir bilgisi gereklidir")
    private String deliveryCity;

    @NotBlank(message = "Zip kodu gereklidir")
    private String deliveryZip;

    // credit card data
    @CreditCardNumber(message = "Geçersiz Kart numarası")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="MM/YY formatında olmalıdır")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Geçersiz CVV")
    private String ccCVV;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza (Pizza pizza) {
        this.pizzas.add(pizza);
    }


}
