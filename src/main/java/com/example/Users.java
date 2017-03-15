package com.example;

public class Users {
	

	private final long id;
	
	private final String surname;
	private final String name;
	private final String birth_date;
	private final String email;
	private final String password;
	
	public Users(long id, String surname, String name,  String birth_date, String email, String password) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.birth_date = birth_date;
		this.email = email;
		this.password = password;
	}
	
	public long getId() { return id; }
	public String getSurname() { return surname; }
	public String getName() { return name; }
	public String getBirthDate() { return birth_date; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }

	
}

