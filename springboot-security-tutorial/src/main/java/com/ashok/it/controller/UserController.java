package com.ashok.it.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.it.entity.LoginModel;
import com.ashok.it.entity.User;
import com.ashok.it.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	private UserService userService;
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginModel loginModel){
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginModel.getUsernameOrEmail(),
						loginModel.getPassword())
				);
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		return new ResponseEntity<String>("Login Successful",HttpStatus.OK);
	}

}



/*
 *   authenticationManager has authenticate method to verify Authentication 
 * 
 *   we can set Authentication object in SecurityContextHolder so once user login, his credentials can be used with
 *   all the API call.
 * 
 */