package com.adtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.Audio;

public interface AudioInterface extends JpaRepository<Audio, Integer> {

}
