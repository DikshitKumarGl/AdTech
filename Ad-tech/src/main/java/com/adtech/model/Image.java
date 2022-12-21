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
@Table(name="image")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int imageid;
	@Column(name="product_name")
	private String productName;
	private double productprice;
	@Column(name="Image_Url")
	private String imageurl;
	private float rating;
	@Column(name="Image_Length")
	private float imglength;
	@Column(name="Image_Width")
	private float imgwidth;
	private String company;

}
