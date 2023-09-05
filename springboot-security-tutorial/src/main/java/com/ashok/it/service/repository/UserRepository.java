package com.ashok.it.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.it.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsernameOrEmail(String username,String email);

}
