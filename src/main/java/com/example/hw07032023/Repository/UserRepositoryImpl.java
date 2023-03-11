package com.example.hw07032023.Repository;

import com.example.hw07032023.Model.User;
import com.example.hw07032023.Model.UserDTO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

@Service
public class UserRepositoryImpl implements UserRepository {

	private static Connection connection;
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "myUser";
	private static final String PASSWORD = "123";

	static {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public boolean checkUserExist(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,domain FROM users");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (user.equals(new User(resultSet.getString("name"), resultSet.getString("domain")))) {
					return true;
				}
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addUserToDB(UserDTO userDTO) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT name FROM users");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("name").equals(userDTO.getName())) {
					return false;
				}
			}
			preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
			preparedStatement.setInt(1, findFreeID());
			preparedStatement.setString(2, userDTO.getName());
			preparedStatement.setString(3, userDTO.getDomain());
			preparedStatement.setString(4, userDTO.getPassword());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserByName(String name) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, domain FROM users");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("name").equals(name)) {
					return new User(resultSet.getString("name"), resultSet.getString("domain"));
				}
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<Long, User> getAll() {
		Map<Long, User> users = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name,domain FROM users");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				users.put(resultSet.getLong("id"), new User(resultSet.getString("name"), resultSet.getString("domain")));
			}
			return users;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteUserFromDB(String name, String password) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, password FROM users");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("name").equals(name) && resultSet.getString("password").equals(password)) {
					preparedStatement = connection.prepareStatement("DELETE FROM users WHERE name=?");
					preparedStatement.setString(1, name);
					preparedStatement.executeUpdate();
					return true;
				}
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	private int findFreeID() {
		int id = 1;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM users");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (id == resultSet.getInt("id")) {
					id++;
					continue;
				}
				break;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return id;
	}
}
