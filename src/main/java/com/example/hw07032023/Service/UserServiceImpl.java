package com.example.hw07032023.Service;

import com.example.hw07032023.Model.User;
import com.example.hw07032023.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public boolean checkUserExist(User user) {
		return false;
	}
}
