package com.matchbox.matchboxstickers.config;

import com.matchbox.matchboxstickers.entity.Customer;
import com.matchbox.matchboxstickers.entity.Order;
import com.matchbox.matchboxstickers.entity.ShippingAddress;
import com.matchbox.matchboxstickers.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.Arrays;

@Configuration
public class SecurityConfig extends AbstractHttpConfigurer<SecurityConfig, HttpSecurity> implements RepositoryRestConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::and) // Enable CORS configuration
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection (only for demonstration purposes, not recommended for production)
                .authorizeRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .httpBasic(); // Enable basic authentication

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Replace with your frontend's origin
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(1800L); // 30 minutes

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Product.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(ShippingAddress.class);
        config.exposeIdsFor(Order.class);
        // Add other entities for which you want to expose the ids
    }
}
