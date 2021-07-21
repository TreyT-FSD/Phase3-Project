package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.app.model.Admin;
import com.app.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;
	
	public boolean authenticateAdmin(Admin admin) {
		
		ExampleMatcher customMatcher = ExampleMatcher.matchingAny().withMatcher("adminUsername", GenericPropertyMatchers.contains().ignoreCase());
		
		Example<Admin> example = Example.of(admin, customMatcher);
		
		Optional<Admin> result = adminRepo.findOne(example);
		
		//TODO: similar to flyaway, we could do a check to see if the DB has admin creds and if not insert the default creds?
		if (result.isPresent()) {
			//System.err.println("Found Admin in DB: " + result.get());
			return result.get().getAdminPwd().compareTo("password") == 0;
		}
		return false;
	}

}
