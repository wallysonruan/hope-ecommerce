package com.hopeecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data 
@Builder
public class Ong{
	
	@Id
	@Column (name="ud")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column  (name="name", nullable=true)
	private String name;
	
	@Column  (name="cnpj", nullable=true)
	private String cnpj;
	
	@Column  (name="email", nullable=true)
	private String email;	
}