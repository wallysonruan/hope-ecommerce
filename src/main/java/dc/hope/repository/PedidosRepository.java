package dc.hope.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import dc.hope.models.Pedido;


public interface PedidosRepository extends JpaRepository <Pedido, Long> {


}
