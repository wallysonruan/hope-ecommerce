package com.hopeecommerce.entities;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	private Integer storage;
	private Double donationPercentage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStorage() {
		return storage;
	}
	public void setStorage(Integer storage) {
		this.storage = storage;
	}
	public Double getDonationPercentage() {
		return donationPercentage;
	}
	public void setDonationPercentage(Double donationPercentage) {
		this.donationPercentage = donationPercentage;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", storage=" + storage
				+ ", donationPercentage=" + donationPercentage + "]";
	}
	
}
