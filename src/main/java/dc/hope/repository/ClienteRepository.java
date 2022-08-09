package dc.hope.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dc.hope.models.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long>{

  Optional<Clientes>findByClientes(String cpf, String nome, String email, String telefone);

}