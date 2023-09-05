package com.ashok.it.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashok.it.entity.User;
import com.ashok.it.service.repository.UserRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	@Override
	public User saveUser(User user) {
		// Before Saving the user, it's password should be encrypted
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
}
