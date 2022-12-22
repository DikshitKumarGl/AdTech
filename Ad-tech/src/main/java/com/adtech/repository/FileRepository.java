package com.adtech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.File;

public interface FileRepository extends JpaRepository<File,Long> {


    public Optional<File> findByName(String fileName);
 
}