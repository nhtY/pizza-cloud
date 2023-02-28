package pizzas;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class PizzaOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date placedAt = new Date();

    /** The name of the person who will receive the order **/
    @NotBlank(message = "Teslim alacak kişinin adı gereklidir")
    private String deliveryName;

    /** Street info of the delivery address **/
    @NotBlank(message = "Cadde-Sokak bilgisi gereklidir")
    private String deliveryStreet;

    /** City info of the delivery address **/
    @NotBlank(message = "Şehir bilgisi gereklidir")
    private String deliveryCity;

    /** Zip code of the delivery address **/
    @NotBlank(message = "Zip kodu gereklidir")
    private String deliveryZip;

    // credit card data

    /** Credit Card number **/
    @CreditCardNumber(message = "Geçersiz Kart numarası")
    private String ccNumber;

    /** Credit Card expiration date MM/YY **/
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="MM/YY formatında olmalıdır")
    private String ccExpiration;

    /** Credit Card CVV**/
    @Digits(integer = 3, fraction = 0, message = "Geçersiz CVV")
    private String ccCVV;

    /** List of ordered pizzas **/
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>();

    /**
     * When a pizza is designed add it into the order list.
     * @param pizza the designed Pizza object.
     */
    public void addPizza (Pizza pizza) {
        this.pizzas.add(pizza);
    }


}
