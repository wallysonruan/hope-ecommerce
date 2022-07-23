package com.hopeecommerce.entities;

import java.io.Serializable;

import com.hopeecommerce.utils.Email;
import com.hopeecommerce.utils.PhoneNumber;

import lombok.Data;

@Data
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	private String name;
	private Email email;
	private PhoneNumber phoneNumber;
		
}
