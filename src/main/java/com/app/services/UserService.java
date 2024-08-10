package com.app.services;

import java.util.List;

import com.app.dto.UserDto;
import com.app.entity.Role;

public interface UserService {
	UserDto registerUser(UserDto registerUser);

	UserDto login(String email, String aadharNumber, String password);

	List<UserDto> getUsersByRole(Role role);

	UserDto updateUser(String aadharNumber, UserDto userDto);

	void deleteUser(String aadharNumber);
}
