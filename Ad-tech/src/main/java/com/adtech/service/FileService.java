package com.adtech.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adtech.exception.FileExistingException;
import com.adtech.exception.FileNotFoundException;
import com.adtech.model.File;
import com.adtech.repository.FileRepository;
import com.adtech.util.ImageUtils;

@Service
public class FileService {

    @Autowired
    private FileRepository filerepository;
    
// Inserting new file    
    public String uploadfile(MultipartFile file) throws IOException {
        	
    	
    		if(filerepository.findByName(file.getOriginalFilename()).isPresent()) {
    			
    			throw new FileExistingException("File already Exist");
    			
    		}else {
    			
    			File imageData = filerepository.save(File.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes())).build());
                if (imageData != null) {
                    return "file Added successfully : " + file.getOriginalFilename()+" file id: "+imageData.getId();
                }
                return null;
    			
    		}
        
        
    }
    	
    	
    	
 
//for getting file in api.
    public byte[] downloadFile(String fileName){
    	if(filerepository.findByName(fileName).isPresent()){
    		 Optional<File> dbImageData = filerepository.findByName(fileName);
    	        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
    	        return images;	
    	}
        throw new FileNotFoundException("File Not found");
    }

    
    
//  Used to update file with the help of id;
    
  public String UpdateFile(Long id,MultipartFile file) throws IOException {
	  
  	if(filerepository.findById(id).isPresent() && (!filerepository.findByName(file.getOriginalFilename()).isPresent()))
  	{
  		Optional<File> opimage=filerepository.findById(id);
  		File img=opimage.get();
  		img.setId(id);
  		img.setType(file.getContentType());
  		img.setName(file.getOriginalFilename());
  		img.setImageData(ImageUtils.compressImage(file.getBytes()));
  		
  		filerepository.save(img);
  		
  		return "file updated successfully : " +file.getOriginalFilename();
  				
  	}
  	else {
  		throw new FileNotFoundException("File with id is not present or file which you are tying to upload already exist");
  	}
  	
  	
  }
    
// used to Delete file by id; 
    public String deleteFile(long id) {
    	
    	if(filerepository.findById(id).isPresent())
    	{	
    		filerepository.deleteById(id);
    		return "Deleted Successfully";
    		
    	}
    	else {
    		throw new FileNotFoundException("Oops! File not found");
    	}
    }
    
    
    
//  
////for getting list of image
//    public List<byte []> downloadMultipleImages(long companyid){
//    	
//    	if(adrepo.findById(companyid).isPresent()) {
//    		List<byte[]> manyimage=new ArrayList<byte[]>();
//    		
////        	List<File> img=repository.findByCompanyid(companyid);
////        	for(int i=0;i<img.size();i++)
////        	{
////        		
////        		if(img.get(i).getType().equals("image/png")) 
////        		{	
////        		byte[] one=ImageUtils.decompressImage(img.get(i).getImageData());
////        		manyimage.add(one);
////        		}
////        		
////        	}
//        	
//        	return manyimage;
//        }
//    	else {
//    			throw new CompanyNotFoundException("Company Id Not present");
//    	}
//    	
//    }
//    		
    	
    	
    	
    
    
}