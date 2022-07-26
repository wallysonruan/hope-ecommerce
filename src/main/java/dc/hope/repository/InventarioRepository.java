package dc.hope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dc.hope.models.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long>{

}