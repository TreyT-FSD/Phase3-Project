package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User getUserById(long id) {
		Optional<User> result = userRepo.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User AddUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	public User updateUser(long id, User updatedUser) {
		return userRepo.findById(id)
				.map(user -> {
					user.setUserFirstName(updatedUser.getUserFirstName());
					user.setUserLastName(updatedUser.getUserLastName());
					user.setUserEmail(updatedUser.getUserEmail());
					user.setUserPwd(updatedUser.getUserPwd());
					return userRepo.save(user);
		}).orElseGet(() -> {
			updatedUser.setUserId(id);
			return userRepo.save(updatedUser);
		});
	}
	
	public boolean isAuthenticatedUser(User user) {
		
		User u = getUserByEmail(user);
		
		if(u != null) {
			return (u.getUserPwd().toLowerCase()
					.compareTo(user.getUserPwd().toLowerCase()) == 0);
		}
		return false;
	}
	
	public User getUserByEmail(User user) {
		
		User tempUser = new User(null, null, user.getUserEmail(), null);		
		ExampleMatcher customerMatcher = ExampleMatcher.matching().withIgnorePaths("userId");		
		Example<User> exampleUser = Example.of(tempUser, customerMatcher);
		
		Optional<User> result = userRepo.findOne(exampleUser);
		
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

}
