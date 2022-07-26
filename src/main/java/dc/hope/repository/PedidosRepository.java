package dc.hope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dc.hope.models.Pedidos;

public interface PedidosRepository extends JpaRepository <Pedidos, Long> {
    
}
