package pizzas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pizzas.User;
import pizzas.data.UserRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
          User user = userRepo.findByUsername(username);
            if (user != null)
                return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        (request) -> request
                                .requestMatchers("/design", "/orders/**").hasRole("USER")
                                .requestMatchers("/", "/**").permitAll()
                )
                .formLogin()
                    .loginPage("/login")
                        .defaultSuccessUrl("/design", true)
                .and()
                    .oauth2Login()
                        .loginPage("/login").defaultSuccessUrl("/design", true)
                .and()
                    .logout()
                        .logoutSuccessUrl("/");
        return http.build();
    }

}
