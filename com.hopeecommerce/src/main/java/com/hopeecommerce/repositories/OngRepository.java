package com.hopeecommerce.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.hopeecommerce.entities.Ong;

public interface OngRepository extends JpaRepositoryImplementation<Ong, Long> {
	//No need to insert anything here.
}