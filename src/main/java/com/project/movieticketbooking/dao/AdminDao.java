package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.movieticketbooking.dto.AdminDto;
import com.project.movieticketbooking.entity.Admin;
import com.project.movieticketbooking.entity.User;
import com.project.movieticketbooking.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	AdminRepository AdminRepository;

	@Autowired
	ModelMapper modelMapper;

//	1.save
	public Admin saveAdmin(Admin Admin) {
		return AdminRepository.save(Admin);
	}

//	2.findById
	public AdminDto findAdminById(int id) {
		Optional<Admin> optionalAdmin = AdminRepository.findById(id);
		if (optionalAdmin.isPresent()) {
			return modelMapper.map(optionalAdmin.get(), AdminDto.class);
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Admin> findAllAdmin() {
		return AdminRepository.findAll();
	}

//	4.update
	public Admin updateAdmin(Admin Admin, int id) {
		AdminDto findAdmin = findAdminById(id);
		if (findAdmin != null) {
			Admin.setAdminId(id);
			return Admin;

		}
		return null; // exception will be there if the findAdmin object is null
	}

//	5.delete
	public Admin deleteAdmin(int id) {
		Optional<Admin> foundedAdmin = AdminRepository.findById(null);
		if (foundedAdmin != null) {
			AdminRepository.delete(foundedAdmin.get());
			return foundedAdmin.get();
		}
		return null; // exception will be there for object is not present
	}
	
	public Admin findByEmail(String adminEmail) {
		Admin admin = AdminRepository.findByadminEmail(adminEmail);
		if (admin != null) {
			return admin;
		}
		return null;
	}
	
	public Admin adminLogin(String adminEmail, String adminPassword) {
		Admin admin = AdminRepository.findByadminEmail(adminEmail);
		if (admin != null) {
			if (admin.getAdminPassword().equals(adminPassword)) {
				return admin;
			}
			return null;
		}
		return null;
	}
}
