package com.example.hw07032023.Repository;

import com.example.hw07032023.Constant.UserConstant;
import com.example.hw07032023.Model.UserDTO;
import org.junit.jupiter.api.*;

class UserRepositoryTest {

	private final UserConstant userConstant = new UserConstant();

	private final UserRepositoryImpl out = new UserRepositoryImpl();

	@BeforeEach
	void createTemporaryTestsUsersInDB() {
		out.addUserToDB(new UserDTO(userConstant.getUserInDB().getName(), userConstant.getUserInDB().getDomain(), userConstant.getTestsPassword()));
	}

	@AfterEach
	void deleteTemporaryTestsUsersFromDB() {
		out.deleteUserFromDB(userConstant.getTestsNameInDB(), userConstant.getTestsPassword());
	}

	@Test
	void shouldReturnUserFromDBByName() {
		Assertions.assertEquals(userConstant.getUserInDB(), out.getUserByName(userConstant.getTestsNameInDB()));
	}

	@Test
	void shouldCheckUserAbsenceInDB() {
		Assertions.assertNull(out.getUserByName(userConstant.getTestsNameNotInDB()));
	}

	@Test
	void shouldCheckDoubleOfUsersInDB() {
		Assertions.assertFalse(out.addUserToDB(new UserDTO(userConstant.getUserInDB().getName(), userConstant.getUserInDB().getDomain(), userConstant.getTestsPassword())));
	}
}