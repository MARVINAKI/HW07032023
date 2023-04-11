package com.example.hw07032023.Service;

import com.example.hw07032023.Model.User;
import com.example.hw07032023.Model.UserDTO;
import com.example.hw07032023.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean checkUserExist(User user) {
		return userRepository.checkUserExist(user);
	}

	@Override
	public boolean addUserToDB(UserDTO userDTO) {
		return userRepository.addUserToDB(userDTO);
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.getUserByName(name);
	}

	@Override
	public Map<Long, User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public boolean deleteUserFromDB(String name, String password) {
		return userRepository.deleteUserFromDB(name, password);
	}
}
