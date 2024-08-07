package com.app.services;

import com.app.dto.UserDto;

public interface UserService {
	UserDto registerUser(UserDto registerUser);

	UserDto login(String email, String aadharNumber, String password);

}
