package com.hopeecommerce.entities;

import java.io.Serializable;
import java.util.Objects;

import com.hopeecommerce.utils.Email;
import com.hopeecommerce.utils.PhoneNumber;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	private String name;
	private Email email;
	private PhoneNumber phoneNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(Id, other.Id);
	}
	
	@Override
	public String toString() {
		return "Client [Id=" + Id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
}
