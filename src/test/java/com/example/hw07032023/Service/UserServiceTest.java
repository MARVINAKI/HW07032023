package com.example.hw07032023.Service;

import com.example.hw07032023.Constant.UserConstant;
import com.example.hw07032023.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	private final UserConstant userConstant = new UserConstant();

	@Mock
	private UserRepository mockRepository;

	@InjectMocks
	private UserServiceImpl out;

	@Test
	void shouldCheckUserExistsInDB() {
		when(mockRepository.checkUserExist(userConstant.getUserInDB())).thenReturn(true);
		assertTrue(out.checkUserExist(userConstant.getUserInDB()));
		verify(mockRepository, times(1)).checkUserExist(userConstant.getUserInDB());
	}

	@Test
	void shouldCheckUserAbsenceInDB() {
		when(mockRepository.checkUserExist(userConstant.userInDB)).thenReturn(false);
		assertFalse(out.checkUserExist(userConstant.getUserInDB()));
		verify(mockRepository, times(1)).checkUserExist(userConstant.getUserInDB());
	}

	@Test
	void shouldCatchSQLExceptionInMethodCheckUserExists() {
		when(mockRepository.checkUserExist(userConstant.getUserInDB())).thenThrow(RuntimeException.class);
		assertThrows(RuntimeException.class, () -> out.checkUserExist(userConstant.getUserInDB()));
	}

	@Test
	void shouldReturnUserInMethodGetUserByName() {
		when(mockRepository.getUserByName(userConstant.getTestsNameInDB())).thenReturn(userConstant.getUserInDB());
		assertEquals(userConstant.getUserInDB(), out.getUserByName(userConstant.testsNameInDB));
		verify(mockRepository, times(1)).getUserByName(userConstant.getTestsNameInDB());
	}

	@Test
	void shouldReturnNullInMethodGetUserByName() {
		when(mockRepository.getUserByName(userConstant.getTestsNameInDB())).thenReturn(null);
		assertNull(out.getUserByName(userConstant.getTestsNameInDB()));
		verify(mockRepository, times(1)).getUserByName(userConstant.getTestsNameInDB());
	}

	@Test
	void shouldCatchSQLExceptionInMethodGetUserByName() {
		when(mockRepository.getUserByName(userConstant.getTestsNameInDB())).thenThrow(RuntimeException.class);
		assertThrows(RuntimeException.class, () -> out.getUserByName(userConstant.getTestsNameInDB()));
	}
}