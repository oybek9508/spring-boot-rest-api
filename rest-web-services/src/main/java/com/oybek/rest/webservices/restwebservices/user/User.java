package com.oybek.rest.webservices.restwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.util.List;
@Entity(name="user_details")
public class User {
@Id
@GeneratedValue
	private Integer id;
	@Size(min = 2, message = "Name must have at least 2 characters")
	@JsonProperty("user_name")
	private String name;
	@Past(message = "Birthdate cannot be future date")
	@JsonProperty("birth_date")
	private LocalDate birthDate;

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "user")
@JsonIgnore
	private List<Posts> posts;

	protected User(){}

	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

}