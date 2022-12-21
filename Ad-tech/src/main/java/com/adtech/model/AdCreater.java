package com.adtech.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="AdCloud")
public class AdCreater {
	
//	For Creating Ad, where we can store (Audio,Video,Image) url,text; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyid;
	private String companyname;
	private String createdtime;
	private String email;
	
	

//	for add list of video currently only meta data.
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id",referencedColumnName = "companyid")
	private List<Video> video;
	
//	for add list of audio currently only meta data.
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="company_id",referencedColumnName = "companyid")
	private List<Audio> audio;

// for add list of image currently only meta data.
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="company_id",referencedColumnName = "companyid")
	private List<Image> image;
// for storing location where we want to  campaign like in different countries,state,vertical.	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id",referencedColumnName = "companyid")
	private List<CampaignSite> campaignSites;
	
	
}
