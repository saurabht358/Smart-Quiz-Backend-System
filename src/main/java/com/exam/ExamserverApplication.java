package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	public static void main(String[] args) {

		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{
		System.out.println("Starting system");

//		User user = new User();
//
//		user.setFirstName("Saurabh");
//		user.setLastName("Tembhurne");
//		user.setEmail("saurabhtembhurne1020@gmail.com");
//		user.setPassword("123");
//		user.setUsername("saurabht7");
//		user.setPhone("935682");
//		user.setProfile("profile.jpg");
//
//		Role role1 = new Role();
//		role1.setRollId(1L);
//		role1.setRollName("ADMIN");
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user,userRoleSet);
//		System.out.println(user1.getUsername());

	}

}
