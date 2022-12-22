package com.adtech.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.Advertiser;

public interface AdvertiserRepository extends JpaRepository<Advertiser, Integer> {
	
public Optional<Advertiser> findByCompanyname(String companyname);


	

}
