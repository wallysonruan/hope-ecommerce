package com.hopeecommerce.requests;

import com.hopeecommerce.entities.Client;
import com.hopeecommerce.utils.Email;
import com.hopeecommerce.utils.PhoneNumber;

import lombok.Data;

@Data
public class ClientRequest {
	Long Id;
	String name;
	Email email;
	PhoneNumber phoneNumber;
	
	public Client toClient() {
		return Client.builder()
				.Id(this.Id)
				.name(this.name)
				.email(this.email)
				.phoneNumber(this.phoneNumber)
				.build();
	}
}