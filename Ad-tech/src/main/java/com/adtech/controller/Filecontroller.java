package com.adtech.controller;




import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adtech.service.FileService;

@RestController
@RequestMapping("/media")
public class Filecontroller {
	@Autowired
	private FileService fileService;

	
	
	@PostMapping("/file")
    public ResponseEntity<?> uploadImage(@RequestBody @RequestParam("file") MultipartFile file) throws IOException
    {
        String uploadImage =fileService.uploadfile(file);
        return ResponseEntity.ok().body(uploadImage);
                
    }
	
	
	@PutMapping("/update-file/file/{id}")
	 public ResponseEntity<?> updatedImage(@RequestBody @RequestParam("file") MultipartFile file,@PathVariable("id") Long id) throws IOException
    {
        String updatefil=fileService.UpdateFile(id, file);
        return ResponseEntity.ok().body(updatefil);
                
    }
	
	
	@GetMapping("/image-file/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] imageData=fileService.downloadFile(fileName);
		
		
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	@GetMapping("/video-file/{fileName}")
	public ResponseEntity<?> downloadVideo(@PathVariable String fileName){
		byte[] videoData=fileService.downloadFile(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("video/mp4"))
				.body(videoData);

	}
	@GetMapping("/audio-file/{fileName}")
	public ResponseEntity<?> downloadAudio(@PathVariable String fileName){
		byte[] audioData=fileService.downloadFile(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("audio/wave"))
				.body(audioData);

	}

	
	@DeleteMapping("/file/{id}")
	public ResponseEntity<String> deleteImage(@PathVariable("id") long id){
		
		return new ResponseEntity<String>(fileService.deleteFile(id),HttpStatus.OK);
	}
	
	
	

}
