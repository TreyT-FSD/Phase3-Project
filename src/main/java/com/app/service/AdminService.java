package com.app.service;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.model.Admin;
import com.app.repository.AdminRepository;

@Service
public class AdminService {
	
	//autowire the AdminRepository here
	AdminRepository adminRepo;
	
	
	public boolean authenticateAdmin(Admin admin) {
		
		Example<Admin> example = Example.of(admin);
		
		Optional<Admin> actual = adminRepo.findOne(example);
		
		if(actual.isPresent()) {
			return true;
		}
		return false;
	}

}
