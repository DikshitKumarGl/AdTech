package com.adtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}