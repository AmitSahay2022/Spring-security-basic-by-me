package com.ashok.it;


          /**
           * Don't be Afraid. this project has only CustomUserDetailsService which implements UserDetailsService and
           * override it's method which is loadUserByUsername
           * This method returns User (spring.security package)
           * return new org.springframework.security.core.userdetails.User(usernameOrEmail,user.getPassword(),authorities);
           * 
           * Other things are already known like Get user object as json from the postman and save it into DB
           * for this create Controller, Service, Repository 
           * inside repository i have created Custom finder method 
           *         and inside UserServiceImpl class we have used PasswordEncoder so inside DB encoded password is save
           * 
           * Main thing is Customizing SecurityFilterChain, PasswordEncoder and AuthenticationManager
           * 
           * 
           */


//------------------Starting Point of Application--------------------
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSecurityTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityTutorialApplication.class, args);
	}

}







//------------------------NOTE------------------TO LEARN CONCEPTS----------------
//(1) when we add dependency for spring-boot-starter-security then all the API get default security
//              but how?
//    because first of all, all the request is intercepted by AuthenticationFilter and the default
//    implementation provides security to all the API 
//    
//    but inside the project all the API is not secure. like Home page, Contact Page, Registration/Login
//    These resources should be publicly accessible and 
//    Only few sensitive API need security
//
//    So we should override AuthenticationFilter. in spring security 6.X we write SecurityFilterChain   
//    and provides our own implementation    