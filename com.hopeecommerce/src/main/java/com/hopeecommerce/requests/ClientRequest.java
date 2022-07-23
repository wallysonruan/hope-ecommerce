package com.hopeecommerce.requests;

import com.hopeecommerce.entities.Client;
import com.hopeecommerce.utils.Email;
import com.hopeecommerce.utils.PhoneNumber;

import lombok.Data;

@Data
public class ClientRequest {
	String name;
	String email;
	String phoneNumber;
	
	public Client toClient() {
		return Client.builder()
				.name(this.name)
				.email(this.email)
				.phoneNumber(this.phoneNumber)
				.build();
	}
}