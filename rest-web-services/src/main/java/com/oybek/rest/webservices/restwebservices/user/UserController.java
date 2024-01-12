package com.oybek.rest.webservices.restwebservices.user;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oybek.rest.webservices.restwebservices.exception.UserNotFoundException;

@RestController
public class UserController {
	
	private UserDaoService userService;
	
	public UserController(UserDaoService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> fetchAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable int id) {
		User matchingUser =  userService.findById(id);
		if(matchingUser == null) {}
		throw new UserNotFoundException("id: " + id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> insetUser(@RequestBody User user){
		User matchingUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(matchingUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		userService.delete(id);
	}

}
