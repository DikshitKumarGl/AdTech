package com.adtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="video")
public class Video {
//	for storing particular video for a comapny.
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int videoid;
	@Column(name="product_name")
	private String productname;
	private String videourl;
	private double price;
	private int length;
	private int width;
	private float rating;
	private String company;
}
