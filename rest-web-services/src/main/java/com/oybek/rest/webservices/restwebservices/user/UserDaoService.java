package com.oybek.rest.webservices.restwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private int userCounter = 0;
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Jason", LocalDate.now()));
		users.add(new User(2, "Mike", LocalDate.now()));
		users.add(new User(2, "Lisa", LocalDate.now()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user){
		user.setId(++userCounter);
		users.add(user);
		return user;
	}
	
	public void delete(int id) {
		User matchingUser = findById(id);
		users.remove(matchingUser);
	}

}
