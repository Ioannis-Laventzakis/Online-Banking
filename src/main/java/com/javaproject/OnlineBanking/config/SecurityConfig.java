package com.javaproject.OnlineBanking.config;

import com.javaproject.OnlineBanking.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 * Annotated with @Configuration and @EnableWebSecurity to indicate that it's a configuration class for Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Bean for UserDetailsService.
     * @param userService the UserServiceImpl instance.
     * @return the UserServiceImpl instance as a UserDetailsService.
     */
    @Bean
    public UserDetailsService userDetailsService(UserServiceImpl userService) {
        return userService;
    }

    /**
     * Bean for SecurityFilterChain.
     * Configures the security filter chain.
     * @param http the HttpSecurity instance.
     * @return the SecurityFilterChain instance.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                    .requestMatchers("/signup", "/login").permitAll()
                    .requestMatchers("/openAccount").authenticated()
                    .anyRequest().authenticated()
            )
            .formLogin(
                formLogin -> formLogin
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            )
            .logout(
                logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .permitAll()
            );

        return http.build();
    }

    /**
     * Configures the global authentication manager.
     * @param auth the AuthenticationManagerBuilder instance.
     * @param userDetailsService the UserDetailsService instance.
     * @throws Exception if an error occurs during configuration.
     */
    @Autowired
    public void configureGlobal(
        AuthenticationManagerBuilder auth,
        UserDetailsService userDetailsService
    ) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
}