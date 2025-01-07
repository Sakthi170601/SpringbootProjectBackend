package com.project.movieticketbooking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.movieticketbooking.dto.AdminDto;
import com.project.movieticketbooking.entity.Admin;
import com.project.movieticketbooking.entity.User;
import com.project.movieticketbooking.service.AdminService;
import com.project.movieticketbooking.util.ResponseStructure;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Admin>> saveOwner(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDto>> findBookigById(@RequestParam int id) {
		return adminService.findAdminById(id);
	}

	@GetMapping("findAllAdmin")
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllOwner() {
		return adminService.findAllAdmin();
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateOwner(@RequestBody Admin admin, @RequestParam int id) {
		return adminService.updateAdmin(admin, id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admin>> deleteOwner(@RequestParam int id) {
		return adminService.deleteAdmin(id);
	}
	@GetMapping("adminLogin")
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(String adminEmail, String adminPassword) {
		return adminService.adminLogin(adminEmail, adminPassword);
	}
}
