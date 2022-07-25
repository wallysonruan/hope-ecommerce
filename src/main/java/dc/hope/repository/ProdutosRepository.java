package dc.hope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dc.hope.models.Produtos;

public interface ProdutosRepository extends JpaRepository <Produtos, Long> {
    
}
