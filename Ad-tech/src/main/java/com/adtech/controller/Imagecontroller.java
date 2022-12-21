package com.adtech.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.adtech.service.StorageService;

@RestController

public class Imagecontroller {
	@Autowired
	private StorageService storageService;
	
	@PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestBody @RequestParam("image")MultipartFile file,@RequestParam("companyid") int companyid) throws IOException {
        String uploadImage=storageService.uploadImage(file,companyid);
        return ResponseEntity.ok().body(uploadImage);
                
    }
	
	
	@PutMapping("/image/{id}")
	 public ResponseEntity<?> updatedImage(@RequestBody @RequestParam("image")MultipartFile file,@PathVariable("id") Long id) throws IOException
    {
        String updateImage=storageService.UpdateImage(id, file);
        return ResponseEntity.ok().body(updateImage);
                
    }
	
	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] imageData=storageService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	@GetMapping("/video/{fileName}")
	public ResponseEntity<?> downloadVideo(@PathVariable String fileName){
		byte[] imageData=storageService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("video/mp4"))
				.body(imageData);

	}
	@GetMapping("/audio/{fileName}")
	public ResponseEntity<?> downloadAudio(@PathVariable String fileName){
		byte[] imageData=storageService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("audio/wave"))
				.body(imageData);

	}
	
	
	@GetMapping(value="/img/{companyid}")
	public List<byte []> getList(@PathVariable("companyid") int companyid) {
		List<byte []> imageData= storageService.downloadMultipleImages(companyid);
		return imageData;
		
		
	}
	
	@DeleteMapping("/image/{id}")
	public ResponseEntity<String> deleteImage(@PathVariable("id") long id){
		
		return new ResponseEntity<String>(storageService.deleteImage(id),HttpStatus.OK);
	}
	
	
	

}
