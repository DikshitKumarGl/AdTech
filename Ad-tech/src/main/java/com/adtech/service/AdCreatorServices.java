package com.adtech.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adtech.exception.CompanyIdNotFound;
import com.adtech.exception.CompanyNotFoundException;
import com.adtech.model.AdCreater;
import com.adtech.model.Audio;
import com.adtech.model.CampaignSite;
import com.adtech.model.Image;
import com.adtech.model.Video;
import com.adtech.repository.AdCreatorRepository;
@Service
public class AdCreatorServices {
	
		@Autowired
		private AdCreatorRepository mainservice;
		
		
//for creating ad	 (Post)	
		public AdCreater add_advertise(AdCreater dspmain)
		{ 
			Date d=new Date();
			AdCreater ad=new AdCreater();
			ad.setEmail(dspmain.getEmail());
			ad.setCreatedtime(d.toString());
			ad.setCompanyname(dspmain.getCompanyname());
			
			List<Audio> audio=new ArrayList<Audio>();
			dspmain.getAudio().forEach((e)->{
				Audio audio1=new Audio();
				audio1.setAudioby(e.getAudioby());
				audio1.setAudioid(e.getAudioid());
				audio1.setAudiourl(e.getAudiourl());
				audio1.setCompany(dspmain.getCompanyname());
				audio1.setPrice(e.getPrice());
				audio1.setProductname(e.getProductname());
				audio1.setRating(e.getRating());	
				
//				updating value;
				audio.add(audio1);
			});
			
			ad.setAudio(audio);
			
			List<Image> image=new ArrayList<Image>();
			dspmain.getImage().forEach((e)->{
				Image img=new Image();
				img.setImageid(e.getImageid());
				img.setProductName(e.getProductName());
				img.setProductprice(e.getProductprice());
				img.setImglength(e.getImglength());
				img.setImgwidth(e.getImgwidth());
				img.setImageurl(e.getImageurl());
				img.setRating(img.getRating());
				img.setCompany(dspmain.getCompanyname());
				
				image.add(img);
			});
			ad.setImage(image);
			
			
			List<Video> video=new ArrayList<>();
			dspmain.getVideo().forEach((e)->{
				Video vid=new Video();
				vid.setVideoid(e.getVideoid());
				vid.setProductname(e.getProductname());
				vid.setVideourl(e.getVideourl());
				vid.setRating(e.getRating());
				vid.setWidth(e.getWidth());
				vid.setLength(e.getLength());
				vid.setPrice(e.getPrice());
				vid.setCompany(dspmain.getCompanyname());
				
				video.add(vid);
			
			});
			ad.setVideo(video);
			List<CampaignSite> campg=new ArrayList<>();
			dspmain.getCampaignSites().forEach((e)->{
				CampaignSite cmg=new CampaignSite();
				cmg.setCampaignid(e.getCampaignid());
				cmg.setCountry(e.getCountry());
				cmg.setDevice(e.getDevice());
				cmg.setVertical(e.getVertical());
				cmg.setState(e.getState());
				campg.add(cmg);
			});
			ad.setCampaignSites(campg);
			
			return mainservice.save(ad);
		}
		public List<AdCreater> get_data()
		{
			return mainservice.findAll();
		}
	
		
// for geting all data by Company name;
		public Optional<AdCreater> getbycompanyname(String customer)
		{

			if(mainservice.findByCompanyname(customer).isPresent())
			{
				Optional<AdCreater> ad=mainservice.findByCompanyname(customer);
				return ad;
			}else {
				throw new CompanyNotFoundException("Company name Not found");
			}
		}
// for deleting a particular data by companyId;	
		public String delByCompanyName(int id)
		{
			if(mainservice.findById(id).isPresent())
			{
				mainservice.deleteById(id);
				return "Successfully Deleted";
			}
			else {
				throw new CompanyNotFoundException("OOPs, Company Not Found");
			}
			
			
			
		}
		public AdCreater getupdate(int id, AdCreater ad) {
			
			if(mainservice.findById(id).isPresent())
			{
				Optional<AdCreater> find=mainservice.findById(id);
				
				AdCreater ad1=find.get();
				return mainservice.save(ad);
				
				
			}else {
				throw new CompanyIdNotFound("Company Id Not found");
			}
			
		}
}
