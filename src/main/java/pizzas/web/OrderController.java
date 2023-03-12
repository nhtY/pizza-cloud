package pizzas.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pizzas.PizzaOrder;
import pizzas.User;
import pizzas.data.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController (OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal User user,
                            @ModelAttribute PizzaOrder order) {

        if(order.getDeliveryName() == null) {
            order.setDeliveryName(user.getFullName());
        }

        if (order.getDeliveryStreet() == null) {
            order.setDeliveryStreet(user.getStreet());
        }

        if (order.getDeliveryCity() == null) {
            order.setDeliveryCity(user.getCity());
        }

        if (order.getDeliveryZip() == null) {
            order.setDeliveryZip(user.getZip());
        }

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid PizzaOrder pizzaOrder, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user){
        if(errors.hasErrors()) {
            return "orderForm"; // same page
        }

        pizzaOrder.setUser(user); // who is ordering the pizza
        log.info("User: " + user.getUsername() + " is giving an order");

        orderRepo.save(pizzaOrder);
        log.info("Order taken is saved:  {}", pizzaOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
