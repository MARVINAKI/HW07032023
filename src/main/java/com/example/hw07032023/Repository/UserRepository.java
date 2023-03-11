package com.example.hw07032023.Repository;

import com.example.hw07032023.Model.User;
import com.example.hw07032023.Model.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository {

	boolean checkUserExist(User user);

	boolean addUserToDB(UserDTO userDTO);

	User getUserByName(String name);

	Map<Long, User> getAll();

	boolean deleteUserFromDB(String name, String password);
}
