package com.hopeecommerce.entities;

import java.io.Serializable;

import com.hopeecommerce.utils.Cnpj;
import com.hopeecommerce.utils.Email;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Ong implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long Id;
	private String name;
	private Cnpj cnpj;
	private Email email;
	
}