package com.hopeecommerce.requests;

import com.hopeecommerce.entities.Ong;
import com.hopeecommerce.utils.Cnpj;
import com.hopeecommerce.utils.Email;

import lombok.Data;

@Data
public class OngRequest {
	Long Id;
	String name;
	Cnpj cnpj;
	Email email;
	
	public Ong toOng() {
		return Ong.builder()
				.Id(Id)
				.name(name)
				.cnpj(cnpj)
				.email(email)
				.build();
	}
}
