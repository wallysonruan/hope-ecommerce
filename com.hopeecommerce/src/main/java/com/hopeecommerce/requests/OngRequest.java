package com.hopeecommerce.requests;

import com.hopeecommerce.utils.Cnpj;
import com.hopeecommerce.utils.Email;

import lombok.Data;

@Data
public class OngRequest {
	Long Id;
	String name;
	Cnpj cnpj;
	Email email;
}
