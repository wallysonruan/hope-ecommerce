package com.hopeecommerce.requests;

import lombok.Data;

@Data
public class ProductRequest {
	Long id;
	String name;
	Double price;
	Integer storage;
	Double donationPercentage;
}
