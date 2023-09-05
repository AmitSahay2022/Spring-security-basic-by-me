package com.ashok.it.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
	private CustomUserDetailsService userDetailsService;
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth)->{			
			auth.requestMatchers("/home").permitAll();
			auth.requestMatchers("/contact").permitAll();
			auth.requestMatchers(HttpMethod.POST,"/api/users/**").permitAll();
			auth.anyRequest().authenticated();
		});
		http.csrf(csrf->csrf.disable());
		http.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails user1 = User.builder()
//				              .username("amit")
//				              .password(passwordEncoder().encode("test12345"))
//				              .authorities("EMPLOYEE")
//				              .build();
//		UserDetails user2 = User.builder()
//				              .username("sumit")
//				              .password(passwordEncoder().encode("test12345"))
//				              .authorities("MANAGER")
//				              .build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
	
	
	
	
}


//Why @Bean?     -->when we add @Bean at the top of a method then only Spring container is able to
	//manage it's life cycle like create instance, destroy etc.
	
//---------We are overriding Authentication Filter to customize our requirement	-------------------------
	       // SecurityFilterChain is for Authorization not for Authentication


//-----Why PasswordEncoder? most of the implementation class of UserDetailsManager use password encoder bean


//-------now we are going to use database authentication---------

	//------------If we don't create bean of AuthenticationManager  since spring security 6 then also fine but while creating login API, 
	//security context holder uses it
