package dc.hope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dc.hope.models.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long>{

}