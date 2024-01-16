package com.oybek.rest.webservices.restwebservices.jpa;

import com.oybek.rest.webservices.restwebservices.user.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Integer> {
}
