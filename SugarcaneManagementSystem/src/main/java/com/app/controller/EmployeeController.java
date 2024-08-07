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

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;
import com.app.exception.AadharNumberNotFound;
import com.app.services.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@PostMapping
	public ResponseEntity<?> addEmployeeDetails(@RequestBody EmployeeDto dto) {
		EmployeeDto details = service.saveEmployeeDetails(dto);
		return ResponseEntity.ok(details);
	}

//    @GetMapping("/{aadharNumber}")
//    public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable String aadharNumber) {
//        EmployeeDetails details = service.getEmployeeDetailsByAadharNumber(aadharNumber);
//        if (details != null) {
//            return ResponseEntity.ok(details);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
	@GetMapping("/{aadharNumber}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable String aadharNumber) {
		Employee details = service.getEmployeeDetailsByAadharNumber(aadharNumber);
		return ResponseEntity.ok(details);
	}

	@ExceptionHandler(AadharNumberNotFound.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(AadharNumberNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
