package com.project.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.movieticketbooking.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByuserEmail(String userEmail);
}
