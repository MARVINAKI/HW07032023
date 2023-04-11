package com.example.hw07032023.Constant;

import com.example.hw07032023.Model.User;
import lombok.Data;

@Data
public class UserConstant {

	public final String testsNameInDB = "testsName_1";
	public final String testsNameNotInDB = "testsName_2";
	public final String testsDomainInDB = "testsDomain_1";
	public final String testsDomainNotInDB = "testsDomain_2";

	private final String testsPassword = "testsPassword";

	public final User userInDB = new User(testsNameInDB, testsDomainInDB);
	public final User userNotInDB = new User(testsNameNotInDB, testsDomainNotInDB);


}
