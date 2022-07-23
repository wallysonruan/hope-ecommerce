package com.hopeecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hopeecommerce.entities.Client;
public interface ClientRepository extends JpaRepository<Client, Long>{
	//No need to insert anything here.
}