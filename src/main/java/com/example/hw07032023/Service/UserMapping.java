package com.example.hw07032023.Service;

import com.example.hw07032023.Model.User;
import com.example.hw07032023.Model.UserDTO;

public class UserMapping {

	public UserDTO mapToUserDTO(User user, String password) {
		return new UserDTO(user.getName(), user.getDomain(), password);
	}

	public User mapToUser(UserDTO userDTO) {
		return new User(userDTO.getName(), userDTO.getDomain());
	}
}
