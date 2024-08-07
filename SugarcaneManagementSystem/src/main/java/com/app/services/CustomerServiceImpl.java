package com.app.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CustomerDto;
import com.app.entity.Customer;
import com.app.entity.User;
import com.app.exception.AadharNumberNotFound;
import com.app.repositry.CustomerRepository;
import com.app.repositry.UserRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDto addcustomer(CustomerDto customersdto) {
		User customer = userRepo.findByAadharNumber(customersdto.getAadharNumber());
		if (customer == null) {
			throw new AadharNumberNotFound(
					"Customer with Aadhar number " + customersdto.getAadharNumber() + " not found.");
		}
		Customer custDetails = mapper.map(customersdto, Customer.class);
		Customer details = customerRepo.save(custDetails);
		// Save employee details to database
		return mapper.map(details, CustomerDto.class);
	}

	public Customer getEmployeeDetailsByAadharNumber(String aadharNumber) {
		return customerRepo.findByAadharNumber(aadharNumber);
	}

}
