package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Pedidos;

public interface PedidosRepository extends JpaRepository <Pedidos, Long> {
    
}
