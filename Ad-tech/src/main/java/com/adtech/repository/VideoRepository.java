package com.adtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {

}
