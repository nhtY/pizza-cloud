package pizzas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// asdaasd
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
