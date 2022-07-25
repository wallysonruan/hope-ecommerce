package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long>{

}