package com.oybek.rest.webservices.restwebservices.jpa;

import com.oybek.rest.webservices.restwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>   {
}
