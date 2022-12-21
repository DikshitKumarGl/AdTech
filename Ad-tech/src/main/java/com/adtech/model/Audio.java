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
@Table(name="Audio")
public class Audio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int audioid;
	@Column(name="product_name")
	private String productname;
	private String audiourl;
	private String audioby;
	private double price;
	private float rating;
	private String company;
}
