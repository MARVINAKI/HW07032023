package com.example.hw07032023.Service;


import com.example.hw07032023.Model.User;
import com.example.hw07032023.Model.UserDTO;

import java.util.Map;

public interface UserService {

	boolean checkUserExist(User user);

	boolean addUserToDB(UserDTO userDTO);

	User getUserByName(String name);

	Map<Long, User> getAll();

	boolean deleteUserFromDB(String name, String password);
}
