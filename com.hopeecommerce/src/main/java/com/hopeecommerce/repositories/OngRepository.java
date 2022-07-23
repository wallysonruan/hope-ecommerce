package com.hopeecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hopeecommerce.entities.Ong;

public interface OngRepository extends JpaRepository<Ong, Long> {
	//No need to insert anything here.
}