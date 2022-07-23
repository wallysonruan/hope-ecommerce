package com.hopeecommerce.requests;

import com.hopeecommerce.entities.Ong;
import com.hopeecommerce.utils.Cnpj;
import com.hopeecommerce.utils.Email;

import lombok.Data;

@Data
public class OngRequest {
	String name;
	String cnpj;
	String email;
	
	public Ong toOng() {
		return Ong.builder()
				.name(this.name)
				.cnpj(this.cnpj)
				.email(this.email)
				.build();
	}
}
