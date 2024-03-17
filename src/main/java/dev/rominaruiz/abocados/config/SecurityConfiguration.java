package dev.rominaruiz.abocados.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Value("${api-endpoint}")
    String endpoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .logout(out -> out
                        .logoutUrl(endpoint + "/logout")
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(HttpMethod.GET, endpoint + "/ingredients/**").permitAll()
                        .requestMatchers(HttpMethod.GET, endpoint + "/ingredients/name/**").permitAll()
                        .requestMatchers(HttpMethod.POST, endpoint + "/ingredients").permitAll()
                        .requestMatchers(HttpMethod.PUT, endpoint + "/ingredients/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/ingredients/**").permitAll()
                        .requestMatchers(HttpMethod.GET, endpoint + "/categories/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/categories/**").permitAll()
                        .requestMatchers(HttpMethod.GET, endpoint + "/recipes/**").permitAll()
                        .requestMatchers(HttpMethod.GET, endpoint + "/recipes/name/**").permitAll()
                        .requestMatchers(HttpMethod.POST, endpoint + "/recipes").permitAll()
                        .requestMatchers(HttpMethod.PUT, endpoint + "/recipes/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/recipes/**").permitAll()
                        .requestMatchers(HttpMethod.GET, endpoint + "/recipesIngredients").permitAll()
                        .requestMatchers(HttpMethod.POST, endpoint + "/recipesIngredients/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/recipesIngredients/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, endpoint + "/recipesIngredients/**").permitAll()

                        .requestMatchers(HttpMethod.POST, endpoint + "/images").permitAll()
                        .anyRequest().authenticated())
                // .userDetailsService(jpaUserDetailsService)
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}