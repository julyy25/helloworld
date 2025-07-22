package com.learning.demo.config;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        		.cors(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                .sessionFixation().none() // Avoid session fixation protection
                )
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/public/**").permitAll()
                                .requestMatchers("/hello/**").permitAll()
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/h2-console/**").permitAll()
                                //.requestMatchers("/**").permitAll() // Allow all endpoints to be acceissble publically without any key.
                                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> {
                    headers.cacheControl(HeadersConfigurer.CacheControlConfig::disable);
                    headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin);
                });

        return http.build();
    }
    
    
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000")); 
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true); 

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); 
        return source;
    }
}
