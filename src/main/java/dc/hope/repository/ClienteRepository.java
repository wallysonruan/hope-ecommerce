package dc.hope.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dc.hope.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

   

}