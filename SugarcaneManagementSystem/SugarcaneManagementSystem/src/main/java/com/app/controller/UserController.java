package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/registration")
	@Operation(description = "Add User")
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.registerUser(userDto));
	}
}
