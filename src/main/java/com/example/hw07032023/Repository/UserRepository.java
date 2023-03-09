package com.example.hw07032023.Repository;

import com.example.hw07032023.Model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

	void save(User user);

	User find(User user);

	List<String> findAll();

	boolean delete(User user);

}
