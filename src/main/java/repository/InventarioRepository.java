package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long>{

}