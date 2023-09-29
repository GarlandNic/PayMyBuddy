package com.openclassrooms.PayMyBuddy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/", "/newUser").permitAll()
			.requestMatchers("/admin").hasRole("ADMIN")
			.anyRequest().authenticated()
		)
		.formLogin((form) -> form
			.loginPage("/login")
			.permitAll()
		)
		.logout((logout) -> logout.permitAll());

		return http.build();
	}

    
//    Ces utilisateurs seront définis en mémoire, bien que dans des projets de production 
// 		cette méthode est à proscrire au bénéfice d’utilisateurs stockées par exemple dans une base de données.
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails user =
			 User.builder()
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		// UserService qui override userdetailservice.loaduserbyusername
	}
}
