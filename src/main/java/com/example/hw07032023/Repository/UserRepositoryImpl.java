package com.example.hw07032023.Repository;

import com.example.hw07032023.Model.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

	private List<String> userList;

	@Override
	public void save(User user) {

	}

	@Override
	public User find(User user) {
		return null;
	}

	@Override
	public List<String> findAll() {
		return null;
	}

	@Override
	public boolean delete(User user) {
		return false;
	}
}
