package com.adtech.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="advertiser")
public class Advertiser {
	
//	For Creating Ad, where we can store (Audio,Video,Image) url,text; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int advertiserid;
	private String companyname;
	private String createdtime;
	private int companyid;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Ad ad;



	
	
}
