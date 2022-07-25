package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Produtos;

public interface ProdutosRepository extends JpaRepository <Produtos, Long> {
    
}
