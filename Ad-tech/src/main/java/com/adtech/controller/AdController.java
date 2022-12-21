package com.adtech.controller;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adtech.model.AdCreater;
import com.adtech.service.AdCreatorServices;
import com.adtech.service.VideoService;

@RestController
public class AdController {
	
	@Autowired
	private AdCreatorServices dspService;
	
	
	
	@PostMapping("/add-data")
	public ResponseEntity<AdCreater> addData(@RequestBody AdCreater dspmain)
	{
		return new ResponseEntity<>(dspService.add_advertise(dspmain),HttpStatus.ACCEPTED);
	}
	@GetMapping(value="/get-data",produces = "application/json")
	public ResponseEntity<List<AdCreater>> getdata(){
		
		
		return new ResponseEntity<List<AdCreater>>(dspService.get_data(),HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value="get-data/{customer}",produces = "application/json")
	public ResponseEntity<Optional<AdCreater>> getdataby(@PathVariable("customer") String customer ){
		
			return new ResponseEntity<Optional<AdCreater>>(dspService.getbycompanyname(customer),HttpStatus.FOUND);
	}
	
	@PutMapping(value="get-data/{id}")
	public AdCreater getupdate(@PathVariable("id") int id, @RequestBody AdCreater ad ){
		return dspService.getupdate(id,ad);
	}
	
	
	@DeleteMapping(value="delete-data/{companyid}")
	public ResponseEntity<String> deletedataby(@PathVariable("companyid") int companyid ){
		
		return new ResponseEntity<String>(dspService.delByCompanyName(companyid),HttpStatus.ACCEPTED);
}
	

}
