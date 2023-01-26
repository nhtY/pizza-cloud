package pizzas;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pizzas.web.WebConfig;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WebConfig.class)   // Web test for HomeController
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;    // injects MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(
                        CoreMatchers.containsString("Welcome to...")));
    }
}
