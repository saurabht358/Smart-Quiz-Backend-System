package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {

		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{

		try {
			// Code for creating the admin user first;

			User user = new User();


			user.setFirstName("Saurabh");
			user.setLastName("Tembhurne");
			user.setEmail("saurabhtembhurne1020@gmail.com");
			user.setPassword(this.bCryptPasswordEncoder.encode("123"));
			user.setUsername("saurabht7");
			user.setPhone("935682");
			user.setProfile("profile.jpg");

			Role role1 = new Role();
			role1.setRollId(1L);
			role1.setRollName("ADMIN");

			UserRole userRole = new UserRole();
			userRole.setRole(role1);
			userRole.setUser(user);

			Set<UserRole> userRoleSet = new HashSet<>();
			userRoleSet.add(userRole);

			User user1 = this.userService.createUser(user, userRoleSet);
			System.out.println(user1.getUsername());
		}catch (Exception e){
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}

		System.out.println("Starting system");

	}

}
