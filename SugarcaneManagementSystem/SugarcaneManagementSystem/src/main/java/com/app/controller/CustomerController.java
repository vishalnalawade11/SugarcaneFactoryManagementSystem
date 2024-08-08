package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDto;
import com.app.entity.Customer;
import com.app.exception.AadharNumberNotFound;
import com.app.services.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl custdetailsServices;

	@PostMapping
	public ResponseEntity<?> addEmployeeDetails(@RequestBody CustomerDto dto) {
		CustomerDto details = custdetailsServices.addcustomer(dto);
		return ResponseEntity.ok(details);
	}

	@GetMapping("/{aadharNumber}")
	public ResponseEntity<?> getEmployeeDetails(@PathVariable String aadharNumber) {
		Customer details = custdetailsServices.getEmployeeDetailsByAadharNumber(aadharNumber);
		return ResponseEntity.ok(details);
	}

	@ExceptionHandler(AadharNumberNotFound.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(AadharNumberNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

}
