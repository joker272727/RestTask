package com.example;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.ArrayList;

@RestController
public class UsersController {

	List<Users> users_bd = new ArrayList<Users>();
	int id = 0;

	@RequestMapping("/add")
	public void addusers(@RequestParam(value="name", required=false, defaultValue="EMI") String name,
			@RequestParam(value="surname", required=false, defaultValue="EMI") String surname,
			@RequestParam(value="birth_date", required=false, defaultValue="EMI") String birth_date,
			@RequestParam(value="email", required=false, defaultValue="EMI") String email,
			@RequestParam(value="password", required=false, defaultValue="EMI") String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		Users user = new Users(id, surname, name, birth_date, email, hashedPassword);
		users_bd.add(user);
		id++;
	}
	
	@RequestMapping("/users")
	public List<Users> users(@RequestParam(value="name", required=false, defaultValue="EMI") String name) {
		return users_bd;
	}
	
	@RequestMapping("/delete")
	public void deleteuser(@RequestParam(value="id", required=false, defaultValue="-1") Long id) {
		for(int i = 0; i < users_bd.size(); i++)
			if(users_bd.get(i).getId() == id) users_bd.remove(i);
	}
	
	@RequestMapping("/search")
	public List<Users> searchusers(@RequestParam(value="email", required=false, defaultValue="null") String email) {
		List<Users> outusers = new ArrayList<Users>();
		for(int i = 0; i < users_bd.size(); i++)
			if(users_bd.get(i).getEmail().equals(email))
				outusers.add(users_bd.get(i));
		return outusers;
	}

}
