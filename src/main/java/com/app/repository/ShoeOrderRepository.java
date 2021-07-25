package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.ShoeOrder;

public interface ShoeOrderRepository extends JpaRepository<ShoeOrder,Long> { }
