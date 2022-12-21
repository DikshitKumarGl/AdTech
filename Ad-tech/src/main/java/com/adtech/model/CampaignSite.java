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
@Table(name = "campaignsite")
public class CampaignSite {
// it is used for campaigning site like which country we need to 
//	show ad,in which state.
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int  campaignid;
	private String Country;
	private String  State;
	private String  device;
	private String vertical;
//	@Column(name="com_id")
//	private int id;
	
	
}
