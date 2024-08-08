package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.entity.Role;
import com.app.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@Operation(description = "Add User")
	public ResponseEntity<?> addUser(@RequestBody UserDto userRegis) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.registerUser(userRegis));
	}

	@GetMapping("/customers")
	@Operation(description = "Get All Customers")
	public ResponseEntity<List<UserDto>> getAllCustomers() {
		List<UserDto> customers = userService.getUsersByRole(Role.CUSTOMER);
		return ResponseEntity.status(HttpStatus.OK).body(customers);
	}

	@GetMapping("/farmers")
	@Operation(description = "Get All Farmers")
	public ResponseEntity<List<UserDto>> getAllFarmers() {
		List<UserDto> farmers = userService.getUsersByRole(Role.FARMER);
		return ResponseEntity.status(HttpStatus.OK).body(farmers);
	}

	@GetMapping("/employees")
	@Operation(description = "Get All Employees")
	public ResponseEntity<List<UserDto>> getAllEmployees() {
		List<UserDto> employees = userService.getUsersByRole(Role.EMPLOYEE);
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}

	@GetMapping("/accountants")
	@Operation(description = "Get All Accountants")
	public ResponseEntity<List<UserDto>> getAllAccountants() {
		List<UserDto> accountants = userService.getUsersByRole(Role.ACCOUNTANT);
		return ResponseEntity.status(HttpStatus.OK).body(accountants);
	}
}
