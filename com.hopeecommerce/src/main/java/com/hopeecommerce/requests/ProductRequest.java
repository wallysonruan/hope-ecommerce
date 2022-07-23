package com.hopeecommerce.requests;

import com.hopeecommerce.entities.Product;

import lombok.Data;

@Data
public class ProductRequest {
	String name;
	Double price;
	Integer storage;
	Double donationPercentage;
	
	public Product toProduct() {
		return Product.builder()
		.name(this.name)
		.price(this.price)
		.storage(this.storage)
		.donationPercentage(this.donationPercentage)
		.build();
	}
}
