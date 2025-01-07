package com.project.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.movieticketbooking.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByadminEmail(String adminEmail);
}
