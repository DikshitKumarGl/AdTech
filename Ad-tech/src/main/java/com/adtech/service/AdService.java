package com.adtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adtech.repository.AdRepository;

@Service
public class AdService {

	@Autowired
	private AdRepository adRepo;
}
