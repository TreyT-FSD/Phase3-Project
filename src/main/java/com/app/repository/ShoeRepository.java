package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Shoe;

public interface ShoeRepository extends JpaRepository<Shoe,Long> { }
