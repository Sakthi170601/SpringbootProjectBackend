package com.project.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.UserDao;
import com.project.movieticketbooking.dto.UserDto;
import com.project.movieticketbooking.entity.User;
import com.project.movieticketbooking.exception.ListOfAllUserNotFoundException;
import com.project.movieticketbooking.exception.UserNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

//	1.save
	public ResponseEntity<ResponseStructure<User>> saveUser(User User) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.saveUser(User));
		structure.setMessage("User saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	// 2.findUserById
	public ResponseEntity<ResponseStructure<UserDto>> findUserById(int id) {
		UserDto foundedUser = userDao.findUserById(id);
		if (foundedUser != null) {
			ResponseStructure<UserDto> structure = new ResponseStructure<>();
			structure.setData(foundedUser);
			structure.setMessage("User Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.FOUND);
		}
		throw new UserNotFoundException("For A Given Id User Is Not Present"); // exception will be there
																				// UserNotFoundException
	}

	// 3.findAll
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> User = userDao.findAllUser();
		if (User != null) {
			ResponseStructure<List<User>> structure = new ResponseStructure<>();
			structure.setData(User);
			structure.setMessage("Users Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfAllUserNotFoundException("No Users Not Found"); // exception will be there if list of User is
																		// empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<User>> updateUser(User User, int id) {
		User updatedUser = userDao.updateUser(User, id);
		if (updatedUser != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(updatedUser);
			structure.setMessage("User Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new UserNotFoundException("For Given Id User Data Not Found :)"); // exception will be there if object is
																				// not present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		ResponseEntity<ResponseStructure<UserDto>> foundedUser = findUserById(id);
		if (foundedUser != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			User user = userDao.deleteUser(id);
			structure.setData(user);
			structure.setMessage("User Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new UserNotFoundException("For A given Id Data Is Not Present"); // exception will be there if object is
																				// not present
	}

//	6.find by email return user
	public ResponseEntity<ResponseStructure<User>> findByEmailUser(String userEmail) {
		User user = userDao.findByEmail(userEmail);
		if (user != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setData(user);
			structure.setMessage("User Founded Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new UserNotFoundException("For a given Email User Not Found");

	}

//	8.user login validation for email and password
	public ResponseEntity<ResponseStructure<User>> userLogin(String userEmail, String userPassword) {
		User user = userDao.findByEmail(userEmail);
		if (user != null) {
			if (user.getUserPassword().equals(userPassword)) {
				ResponseStructure<User> structure = new ResponseStructure<>();
				structure.setData(user);
				structure.setMessage("User Founded Successfull");
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
			}
			throw new UserNotFoundException("User Email Or User Password Mismatch");
		}
		throw new UserNotFoundException("For a Given Email User Not Found");
	}

}
