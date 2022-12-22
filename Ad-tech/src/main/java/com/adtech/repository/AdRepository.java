package com.adtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.Ad;

public interface AdRepository extends JpaRepository<Ad, Integer> {

	
	public List<Ad> findByCompanyid(int id);
}
