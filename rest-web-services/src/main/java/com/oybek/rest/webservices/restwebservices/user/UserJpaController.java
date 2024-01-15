package com.oybek.rest.webservices.restwebservices.user;

import com.oybek.rest.webservices.restwebservices.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaController {
	private UserRepository userRepository;

	public UserJpaController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> fetchAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<Optional<User>> findUserById(@PathVariable int id) {
		Optional<User> matchingUser =  userRepository.findById(id);
		if(matchingUser.isEmpty()) {
		throw new UserNotFoundException("id: " + id);
		}
		EntityModel<Optional<User>> entityModel = EntityModel.of(matchingUser);
		return entityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> insetUser(@Valid @RequestBody User user){
		User matchingUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(matchingUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		userRepository.deleteById(id);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Posts> fetchAllPostsByUserId(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()){
			throw new UserNotFoundException("id: " + id);
		}
		return user.get().getPosts();

	}

}
