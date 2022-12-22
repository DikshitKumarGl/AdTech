package com.adtech.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adtech.exception.CompanyIdNotFound;
import com.adtech.exception.CompanyNotFoundException;
import com.adtech.model.Ad;
import com.adtech.model.Advertiser;
import com.adtech.repository.AdRepository;
import com.adtech.repository.AdvertiserRepository;
@Service
public class AdvertiserServices {
	
		@Autowired
		private AdvertiserRepository advertiserRepository;
		@Autowired
		private AdRepository adService;
		
		
//for creating ad with advertiser(Post)	
		public Advertiser add_advertise(Advertiser advertiser)
		{ 
			
			Date d=new Date();
			advertiser.setCreatedtime(d.toString());
			advertiser.getAd().setCompanyid(advertiser.getCompanyid());
			return advertiserRepository.save(advertiser);
		}
	
		
		
		
//getting all details of ad with help of company ID;	
public List<Ad> getbycompanyId(int id) {
			
			List<Ad> list_of_ad=adService.findByCompanyid(id);
			if(list_of_ad.size()>0)
			{
				return list_of_ad;
			}else {
				throw new CompanyIdNotFound("There is no any ads related to this id");
			}
			
			
			
		}


//all advertiser details
		public List<Advertiser> get_data()
		{
			return advertiserRepository.findAll();
		}
	
		
		
		
		
// for deleting a particular data by companyId;	
		public String delByAdvertiserId(int id)
		{
			if(advertiserRepository.findById(id).isPresent())
			{
				advertiserRepository.deleteById(id);
				return "Successfully Deleted";
			}
			else {
				throw new CompanyNotFoundException("OOPs, Company Not Found");
			}
			
			
			
		}
		
//updating the existing details with the help of advetiserId;		
		public Advertiser getupdate(int id, Advertiser ad) {
			
			if(advertiserRepository.findById(id).isPresent())
			{
				
				return advertiserRepository.save(ad);
				
				
			}else {
				throw new CompanyIdNotFound("Company Id Not found");
			}
			
		}



		
}
