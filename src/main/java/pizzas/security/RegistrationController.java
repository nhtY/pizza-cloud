package pizzas.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pizzas.User;
import pizzas.data.UserRepository;


@Controller
@Slf4j
@RequestMapping("/register")
public class RegistrationController {
    // object to be injected:

    // the UserRepository for saving new user
    private UserRepository userRepo;

    // the PasswordEncoder to save password encoded
    private PasswordEncoder passwordEncoder;

    // inject via constructor
    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        User saved = userRepo.save(form.toUser(passwordEncoder));
        log.info("User is registered {}", saved);
        return "redirect:/login";
    }
}
