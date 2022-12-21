package com.adtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adtech.model.Video;
import com.adtech.repository.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videorepository;
	
	
	public List<Video> getvideo()
	{
		return videorepository.findAll();
	}

}
