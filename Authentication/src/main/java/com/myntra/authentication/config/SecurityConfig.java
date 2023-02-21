package com.myntra.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception  {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/loginorsignup/**").permitAll()
                        		 .requestMatchers("/authenticate/**").permitAll()
                        		 .requestMatchers("/profile/**").permitAll()
                        		 .requestMatchers("/address/**").permitAll()
                        		 .requestMatchers("/order/**").permitAll()
                        		 .requestMatchers("/wishlist/**").permitAll()
                        		 .requestMatchers("/bag/**").permitAll()
                        		 .requestMatchers("/coupons/**").permitAll()
                        		 .requestMatchers("/home/**").permitAll()
                        		 .requestMatchers("/product/**").permitAll()
                        		  .anyRequest().authenticated()

                        );
                              
        return http.build();
    }
}
