package com.project.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.AdminDao;
import com.project.movieticketbooking.dto.AdminDto;
import com.project.movieticketbooking.entity.Admin;
import com.project.movieticketbooking.exception.AdminNotFoundException;
import com.project.movieticketbooking.exception.ListOfAdminNotFoundException;
import com.project.movieticketbooking.exception.UserNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

//	1.save
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin Admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setData(adminDao.saveAdmin(Admin));
		structure.setMessage("Admin saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}

	// 2.findAdminById
	public ResponseEntity<ResponseStructure<AdminDto>> findAdminById(int id) {
		AdminDto foundedAdmin = adminDao.findAdminById(id);
		if (foundedAdmin != null) {
			ResponseStructure<AdminDto> structure = new ResponseStructure<>();
			structure.setData(foundedAdmin);
			structure.setMessage("Admin Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.FOUND);
		}
		throw new AdminNotFoundException("Admin Not Present For A Given Id"); // exception will be there
																				// AdminNotFoundException
	}

	// 3.findAll
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin() {
		List<Admin> Admin = adminDao.findAllAdmin();
		if (Admin != null) {
			ResponseStructure<List<Admin>> structure = new ResponseStructure<>();
			structure.setData(Admin);
			structure.setMessage("Admins Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfAdminNotFoundException("Admin's Details Not Found"); // exception will be there if list of Admin
																				// is empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin Admin, int id) {
		Admin updatedAdmin = adminDao.updateAdmin(Admin, id);
		if (updatedAdmin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setData(updatedAdmin);
			structure.setMessage("Admin Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		return null; // exception will be there if object is not present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
		ResponseEntity<ResponseStructure<AdminDto>> foundedAdmin = findAdminById(id);
		if (foundedAdmin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setData(adminDao.deleteAdmin(id));
			structure.setMessage("Admin Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		return null; // exception will be there if object is not present
	}
//	6.find by email return admin
			public ResponseEntity<ResponseStructure<Admin>> findByEmailAdmin(String adminEmail) {
				Admin admin = adminDao.findByEmail(adminEmail);
				if (admin != null) {
					ResponseStructure<Admin> structure = new ResponseStructure<>();
					structure.setData(admin);
					structure.setMessage("Admin Founded Successfull");
					structure.setStatusCode(HttpStatus.OK.value());
					return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
				}
				throw new AdminNotFoundException("For a given Email Admin Not Found");

			}

//			8.admin login validation for email and password
			public ResponseEntity<ResponseStructure<Admin>> adminLogin(String adminEmail, String adminPassword) {
				Admin admin = adminDao.findByEmail(adminEmail);
				if (admin != null) {
					if (admin.getAdminPassword().equals(adminPassword)) {
						ResponseStructure<Admin> structure = new ResponseStructure<>();
						structure.setData(admin);
						structure.setMessage("Admin Founded Successfull");
						structure.setStatusCode(HttpStatus.OK.value());
						return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
					}
					throw new AdminNotFoundException("User Email Or Admin Password Mismatch");
				}
				throw new UserNotFoundException("For a Given Email User Not Found");
			}
}
