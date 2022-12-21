package com.adtech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.ImageStore;

public interface StorageRepository extends JpaRepository<ImageStore,Long> {


    public Optional<ImageStore> findByName(String fileName);
    
    public List<ImageStore>  findByCompanyid(int companyid);
}