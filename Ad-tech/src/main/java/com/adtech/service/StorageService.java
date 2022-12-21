package com.adtech.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adtech.exception.CompanyNotFoundException;
import com.adtech.exception.ImageNotFoundException;
import com.adtech.model.ImageStore;
import com.adtech.repository.AdCreatorRepository;
import com.adtech.repository.StorageRepository;
import com.adtech.util.ImageUtils;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;
    @Autowired
    private AdCreatorRepository adrepo;

    
// Inserting new Image    
    public String uploadImage(MultipartFile file,int id) throws IOException {
        if(adrepo.findById(id).isPresent()) {
        	ImageStore imageData = repository.save(ImageStore.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .companyid(id)
                    .imageData(ImageUtils.compressImage(file.getBytes())).build());
            if (imageData != null) {
                return "file Added successfully : " + file.getOriginalFilename();
            }
            return null;
        	
        }else {
        	throw new CompanyNotFoundException("No Company Id with this id ="+id);
        }
        
    }
    	
    	
    	
 
//for getting image in api.
    public byte[] downloadImage(String fileName){
        Optional<ImageStore> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
  
//for getting list of image
    public List<byte []> downloadMultipleImages(int companyid){
    	
    	if(adrepo.findById(companyid).isPresent()) {
    		List<byte[]> manyimage=new ArrayList<byte[]>();
    		
        	List<ImageStore> img=repository.findByCompanyid(companyid);
        	for(int i=0;i<img.size();i++)
        	{
        		
        		if(img.get(i).getType().equals("image/png")) 
        		{	
        		byte[] one=ImageUtils.decompressImage(img.get(i).getImageData());
        		manyimage.add(one);
        		}
        		
        	}
        	
        	return manyimage;
        }
    	else {
    			throw new CompanyNotFoundException("Company Id Not present");
    	}
    	
    }
    		
    	
    	
    	
    
    
    
//  Used to update data with the help of id;
    
  public String UpdateImage(Long id,MultipartFile file) throws IOException {
  	
  	if(repository.findById(id).isPresent())
  	{
  		Optional<ImageStore> opimage=repository.findById(id);
  		ImageStore img=opimage.get();
  		img.setId(id);
  		img.setType(file.getContentType());
  		img.setName(file.getOriginalFilename());
  		img.setImageData(ImageUtils.compressImage(file.getBytes()));
  		
  		repository.save(img);
  		
  		return "file updated successfully : " +file.getOriginalFilename();
  				
  	}
  	else {
  		throw new ImageNotFoundException("Image with id is not present");
  	}
  	
  	
  }
    
// used to Delete image by id; 
    public String deleteImage(long id) {
    	
    	if(repository.findById(id).isPresent())
    	{	
    		repository.deleteById(id);
    		return "Deleted Successfully";
    		
    	}
    	else {
    		throw new ImageNotFoundException("Oops! Image not found");
    	}
    }
    
    

    
}