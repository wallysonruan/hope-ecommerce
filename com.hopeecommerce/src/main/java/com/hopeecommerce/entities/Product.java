package com.hopeecommerce.entities;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	private Integer storage;
	private Double donationPercentage;
	
}
