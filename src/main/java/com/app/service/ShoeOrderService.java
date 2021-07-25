package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.ShoeOrder;
import com.app.repository.ShoeOrderRepository;

@Service
public class ShoeOrderService {
	
	@Autowired
	ShoeOrderRepository orderRepo;
	
	public ShoeOrder getOrderById(long id) {
		return orderRepo.getById(id);
	}
	
	public List<ShoeOrder> getAllOrders(){
		return orderRepo.findAll();
	}
	
	public ShoeOrder saveOrder(ShoeOrder order) {
		return orderRepo.save(order);
	}
	
	public void deleteOrder(ShoeOrder order) {
		orderRepo.delete(order);
	}

}
