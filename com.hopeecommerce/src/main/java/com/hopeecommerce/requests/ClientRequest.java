package com.hopeecommerce.requests;

import com.hopeecommerce.utils.Email;
import com.hopeecommerce.utils.PhoneNumber;

import lombok.Data;

@Data
public class ClientRequest {
	Long Id;
	String name;
	Email email;
	PhoneNumber phoneNumber;
}