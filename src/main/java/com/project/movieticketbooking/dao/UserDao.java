package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.movieticketbooking.dto.UserDto;
import com.project.movieticketbooking.entity.User;
import com.project.movieticketbooking.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

//	1.save
	public User saveUser(User User) {
		return userRepository.save(User);
	}

//	2.findById
	public UserDto findUserById(int id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return modelMapper.map(optionalUser.get(), UserDto.class);
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

//	4.update
	public User updateUser(User User, int id) {
		UserDto findUser = findUserById(id);
		if (findUser != null) {
			User.setUserId(id);
			return userRepository.save(User);

		}
		return null; // exception will be there if the findUser object is null
	}

//	5.delete
	public User deleteUser(int id) {
		Optional<User> findedUser = userRepository.findById(id);
		if (findedUser.isPresent()) {
			userRepository.delete(findedUser.get());
			return findedUser.get();
		}
		return null; // exception will be there for object is not present
	}

//	6. find user by  email return User
	public User findByEmail(String userEmail) {
		User user = userRepository.findByuserEmail(userEmail);
		if (user != null) {
			return user;
		}
		return null;
	}

//	7.user login validation for email and password
	public User userLogin(String userEmail, String userPassword) {
		User user = userRepository.findByuserEmail(userEmail);
		if (user != null) {
			if (user.getUserPassword().equals(userPassword)) {
				return user;
			}
			return null;
		}
		return null;
	}

}
