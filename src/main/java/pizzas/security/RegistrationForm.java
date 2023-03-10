package pizzas.security;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;
import pizzas.User;

@Data
public class RegistrationForm {

    @NotBlank(message = "Kullanıcı adı boş bırakılamaz")
    @Length(min = 4, message = "En az 4 karakter olmalı")
    private String username;

    @NotBlank(message = "Şifre boş bırakılamaz")
    @Length(min = 8, message = "En az 8 karakter olmalı")
    private String password;

    @NotBlank(message = "Şifre boş bırakılamaz")
    @Length(min = 4, message = "En az 4 karakter olmalı")
    private String fullName;

    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String street;

    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String city;

    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String zip;

    @Pattern(regexp = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", message = "Bu numara formata uygun değil")
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password),
                fullName, street, city, zip, phone);
    }
}
