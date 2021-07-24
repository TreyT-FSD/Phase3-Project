package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Shoe;
import com.app.repository.ShoeRepository;

@Service
public class ShoeService {
	
	@Autowired
	ShoeRepository shoeRepository;
	
	public List<Shoe> getAllShoes(){
		return shoeRepository.findAll();
	}
	
	public Shoe getShoeById(long id) {
		 Optional<Shoe> result = shoeRepository.findById(id);
		 
		 if(result.isPresent()) {
			 return result.get();
		 }
		 return null;
	}
	
	public Shoe addShoe(Shoe shoe) {
		return shoeRepository.save(shoe);
	}
	
	public void deleteShoe(Shoe shoe) {
		shoeRepository.delete(shoe);
	}
	
	public Shoe updateShoe(long id, Shoe udpatedShoe) {
		
		return shoeRepository.findById(id)
				.map(shoe -> {
					shoe.setShoeName(udpatedShoe.getShoeName());
					shoe.setShoePrice(udpatedShoe.getShoePrice());
					shoe.setShoeCategory(udpatedShoe.getShoeCategory());
					return shoeRepository.save(shoe);
				}).orElseGet(() -> {
					udpatedShoe.setShoeId(id);
					return shoeRepository.save(udpatedShoe);
				});
	}
}
