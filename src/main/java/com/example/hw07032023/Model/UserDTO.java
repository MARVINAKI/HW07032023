package com.example.hw07032023.Model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserDTO {
	@NotNull
	private String name;
	@NotNull
	private String domain;
	@NotNull
	private String password;

	public UserDTO(String name, String domain, String password) {
		this.name = name;
		this.domain = domain;
		setPassword(password);
	}

	public final String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		if (getPassword() == null || getPassword().trim().isEmpty()) {
			this.password = password;
		}
	}
}
