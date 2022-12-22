package com.adtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Ad {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int adid;
		@Column(name="product_name")
		private String productName;
		@Column(name="media_fileurl")
		private String mediaFileUrl;
		private String mediatype;
		private String length;
		private String width;
		private int companyid;
		
//		for targeting purpose.
		private String country;
		private String state;
		private String veritcal;
		private String device;
	
	
	

}
