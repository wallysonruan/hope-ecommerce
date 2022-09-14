package dc.hope.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dc.hope.models.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long>{

   

}