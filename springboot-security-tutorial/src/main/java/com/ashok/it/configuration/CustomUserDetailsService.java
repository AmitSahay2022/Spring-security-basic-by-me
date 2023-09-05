package com.ashok.it.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ashok.it.entity.User;
import com.ashok.it.service.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(()->new RuntimeException("Not Found"));
		
		Set<GrantedAuthority> authorities=new HashSet<>();
		
		return new org.springframework.security.core.userdetails.User(usernameOrEmail,user.getPassword(),authorities);
	}
}


/*
 * In this project user has no role, that is why empty Set<GrantedAuthotity>
 * 
 */