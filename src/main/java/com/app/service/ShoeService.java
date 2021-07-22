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
					return shoeRepository.save(shoe);
				}).orElseGet(() -> {
					udpatedShoe.setShoeId(id);
					return shoeRepository.save(udpatedShoe);
				});
				
//		//PUT (replace the existing or save the new tutorial)
//		public Tutorial updateTutorial(long id, Tutorial newTutorial) {
//			//epic one liner using find and map and handles case were its not found
//			return tutorialDao.findById(id)
//				.map(tutorial -> {
//				tutorial.setTitle(newTutorial.getTitle());
//				tutorial.setDescription(newTutorial.getDescription());
//				return tutorialDao.save(tutorial);
//			})
//			.orElseGet(() -> {
//				newTutorial.setId(id);
//				return tutorialDao.save(newTutorial);
//			});
//		}
		
		//return null;
	}
}
