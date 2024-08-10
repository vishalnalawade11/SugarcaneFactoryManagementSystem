package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.exception.InvalidCredentialsException;
import com.app.exception.UserNotFoundException;
import com.app.repositry.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto registerUser(UserDto userDto) {
		// convert Dto to entity
		User user = mapper.map(userDto, User.class);
		User savedUser = userRepo.save(user);
		return mapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto login(String email, String aadharNumber, String password) {
		User user = null;

		if (email != null && !email.isEmpty()) {
			user = userRepo.findByEmailAndPassword(email, password);
		} else if (aadharNumber != null && !aadharNumber.isEmpty()) {
			user = userRepo.findByAadharNumberAndPassword(aadharNumber, password);
		}

		if (user == null) {
			throw new InvalidCredentialsException("Invalid email/Aadhar number or password.");
		}

		// Map to DTO if needed
		return mapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getUsersByRole(Role role) {
		List<User> users = userRepo.findByRole(role);
		return users.stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(String aadharNumber, UserDto userDto) {
		// Find the user by Aadhar number
		User existingUser = userRepo.findByAadharNumber(aadharNumber);
		if (existingUser == null) {
			throw new RuntimeException("User with Aadhar number " + aadharNumber + " not found.");
		}

		// Update user details
		existingUser.setName(userDto.getName());
		existingUser.setEmail(userDto.getEmail());
		existingUser.setPassword(userDto.getPassword());
		existingUser.setRole(userDto.getRole());
		existingUser.setContactNumber(userDto.getContactNumber());
		// Update other fields as necessary

		// Save the updated user
		User updatedUser = userRepo.save(existingUser);

		// Map to DTO and return
		return mapper.map(updatedUser, UserDto.class);
	}

	public void deleteUser(String aadharNumber) {
		User user = userRepo.findByAadharNumber(aadharNumber);
		if (user == null) {
			throw new UserNotFoundException("User with aadhar number " + aadharNumber + " not found.");
		}

		userRepo.delete(user);
	}

}
