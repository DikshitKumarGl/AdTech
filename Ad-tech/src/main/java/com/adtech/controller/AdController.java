package com.adtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adtech.model.Ad;
import com.adtech.model.Advertiser;
import com.adtech.service.AdvertiserServices;

@RestController
@RequestMapping("/advertiser")
public class AdController {
	
	
	
	@Autowired
	private AdvertiserServices advertiserServices;

	
	
	
	//creating new ad for advertiser	
	@PostMapping("/add-ad/new")
	public ResponseEntity<Advertiser> addNewAddvertiser(@RequestBody Advertiser advertiser)
	{
		return new ResponseEntity<Advertiser>(advertiserServices.add_advertise(advertiser),HttpStatus.CREATED);
	}

	
	
	//getting all data of ad by comapnyid;	
	@GetMapping("/get-ad/companyid/{id}")
	public ResponseEntity<List<Ad>>getAdByCompanyId(@PathVariable("id") int id)
	{
		return new ResponseEntity<List<Ad>>(advertiserServices.getbycompanyId(id),HttpStatus.FOUND);
	}
	

	
	
	//update the data by advertiser id
	@PutMapping("/update-data/advertiserid/{id}")
	public ResponseEntity<Advertiser>getUpdate(@PathVariable("id") int id,@RequestBody Advertiser advertiser)
	{
		return new ResponseEntity<Advertiser>(advertiserServices.getupdate(id, advertiser),HttpStatus.ACCEPTED);
	}
	

	
	
	// get all details of Advertiser
	@GetMapping("/get-advertiser/details")
	public List<Advertiser> getAllData(){
		return advertiserServices.get_data();
	}
	
	
	
	
	//@Delete By advertiserid
	@DeleteMapping("/del-davertiser/{id}")
	public ResponseEntity<String> deleteByAdvertiserId(@PathVariable("id") int id)
	{
		return new ResponseEntity<String>(advertiserServices.delByAdvertiserId(id),HttpStatus.GONE);
	}
	


}
