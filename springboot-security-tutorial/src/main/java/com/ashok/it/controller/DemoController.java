package com.ashok.it.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/home")
	public ResponseEntity<String> homePage(){
		return new ResponseEntity<>("Welcome to Ashok IT and Bank",HttpStatus.OK);
	}
    @GetMapping("/loan")
    public ResponseEntity<String> getLoan(){
    	return new ResponseEntity<String>("Get Lone",HttpStatus.OK);
    }
    @GetMapping("/balance")
    public ResponseEntity<String> balance(){
    	return new ResponseEntity<String>("4567830 RS",HttpStatus.OK);
    }
    @GetMapping("/contact")
    public ResponseEntity<String> contact(){
    	return new ResponseEntity<String>("7091043605",HttpStatus.OK);
    }
}
