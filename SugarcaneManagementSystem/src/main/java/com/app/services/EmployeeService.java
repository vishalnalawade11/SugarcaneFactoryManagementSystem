package com.app.services;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;

public interface EmployeeService {
	EmployeeDto saveEmployeeDetails(EmployeeDto dto);

	Employee getEmployeeDetailsByAadharNumber(String aadharNumber);
}
