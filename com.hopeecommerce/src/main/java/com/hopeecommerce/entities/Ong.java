package com.hopeecommerce.entities;

import java.io.Serializable;
import java.util.Objects;

import com.hopeecommerce.utils.Cnpj;
import com.hopeecommerce.utils.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Ong implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long Id;
	private String name;
	private Cnpj cnpj;
	private Email email;
	
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
		Ong other = (Ong) obj;
		return Objects.equals(Id, other.Id);
	}
	
	@Override
	public String toString() {
		return "Ong [Id=" + Id + ", name=" + name + ", cnpj=" + cnpj + ", email=" + email + "]";
	}
	
}