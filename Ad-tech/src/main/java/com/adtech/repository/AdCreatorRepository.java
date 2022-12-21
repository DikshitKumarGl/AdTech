package com.adtech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.AdCreater;

public interface AdCreatorRepository extends JpaRepository<AdCreater, Integer> {
	
public Optional<AdCreater> findByCompanyname(String companyname);


	

}
