package com.hopeecommerce.requests;

import com.hopeecommerce.entities.Product;

import lombok.Data;

@Data
public class ProductRequest {
	Long id;
	String name;
	Double price;
	Integer storage;
	Double donationPercentage;
	
	public Product toProduct() {
		return Product.builder()
		.id(id)
		.name(name)
		.price(price)
		.storage(storage)
		.donationPercentage(donationPercentage)
		.build();
	}
}
