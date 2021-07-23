package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.app.model.Admin;
import com.app.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;
	
	
	//Sample for custom matching
	//https://www.baeldung.com/spring-data-query-by-example
	public boolean authenticateAdmin(Admin admin) {
		
		ExampleMatcher customMatcher = ExampleMatcher
				.matching()
				.withIgnorePaths("adminId","adminPwd");
		
		Example<Admin> example = Example.of(admin, customMatcher);
		
		Optional<Admin> result = adminRepo.findOne(example);
		
		//TODO: similar to flyaway, we could do a check to see if the DB has admin creds and if not insert the default creds?
		if (result.isPresent()) {
			return admin.getAdminPwd().compareTo(result.get().getAdminPwd()) == 0;
		}
		return false;
	}

}
