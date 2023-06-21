package com.orcrist.user;

import com.orcrist.user.dto.UserDTO;
import com.orcrist.user.model.User;
import com.orcrist.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
			UserDTO user = new UserDTO();
			user.setUsername("user1");
			userService.addUser(user);
		};
	}

}
