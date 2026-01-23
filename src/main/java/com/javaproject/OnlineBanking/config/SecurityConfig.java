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
 * Security configuration class for the Online Banking application.
 * Configures authentication and authorization settings.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the UserDetailsService bean.
     *
     * @param userService the user service implementation
     * @return the UserDetailsService bean
     */
    @Bean
    public UserDetailsService userDetailsService(UserServiceImpl userService) {
        return userService;
    }

    /**
     * Configures the security filter chain.
     *
     * @param http the HttpSecurity object
     * @return the SecurityFilterChain bean
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/signup", "/login").permitAll()
                .requestMatchers("/openAccount").authenticated()
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
            );

        return http.build();
    }

    /**
     * Configures global authentication settings.
     *
     * @param auth the AuthenticationManagerBuilder object
     * @param userDetailsService the UserDetailsService bean
     * @throws Exception if an error occurs during configuration
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
}