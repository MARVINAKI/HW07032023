package com.example.hw07032023.Controller;

import com.example.hw07032023.Model.User;
import com.example.hw07032023.Model.UserDTO;
import com.example.hw07032023.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/check")
	public boolean checkUserExist(User user) {
		return userService.checkUserExist(user);
	}

	@PostMapping("/add")
	public boolean addUser(@RequestBody UserDTO userDTO) {
		return userService.addUserToDB(userDTO);
	}

	@GetMapping("/find")
	public ResponseEntity<User> findUserByName(String name) {
		return userService.getUserByName(name) == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(userService.getUserByName(name));
	}

	@GetMapping("/findAll")
	public ResponseEntity<Map<Long, User>> findAll() {
		return userService.getAll() == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(userService.getAll());
	}

	@DeleteMapping("/delete")
	public boolean deleteUser(String name, String password) {
		return userService.deleteUserFromDB(name, password);
	}
}
