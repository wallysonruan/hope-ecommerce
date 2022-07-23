package com.hopeecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data 
@Builder
public class Product{
	
	@Id
	@Column (name="ud")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column (name="name", nullable=true)
	private String name;

	@Column (name="price", nullable=true)
	private Double price;
	
	@Column (name="storage", nullable=true)
	private Integer storage;
	
	@Column (name="donationPercentage", nullable=true)
	private Double donationPercentage;	
}
