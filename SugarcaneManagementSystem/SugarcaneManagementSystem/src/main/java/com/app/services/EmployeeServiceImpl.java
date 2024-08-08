package com.app.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;
import com.app.entity.User;
import com.app.exception.AadharNumberNotFound;
import com.app.repositry.EmployeeRepository;
import com.app.repositry.UserRepository;

@Service
@Transactional
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	public EmployeeDto saveEmployeeDetails(EmployeeDto employeeDto) {
		// Fetch the employee by Aadhar number
		User employee = userRepository.findByAadharNumber(employeeDto.getAadharNumber());
		if (employee == null) {
			throw new AadharNumberNotFound("Employee with Aadhar number " + employeeDto.getAadharNumber() + " not found.");
		}

		// Convert DTO to entity
		Employee employeeDetails = mapper.map(employeeDto, Employee.class);
		// Save employee details to database
		Employee savedEmp = employeeRepository.save(employeeDetails);

		return mapper.map(savedEmp, EmployeeDto.class);
	}

	public Employee getEmployeeDetailsByAadharNumber(String aadharNumber) {
		return employeeRepository.findByAadharNumber(aadharNumber);
	}
}
