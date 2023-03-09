package com.example.hw07032023.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	@NotNull
	private String name;
	@NotNull
	private String password;
}
