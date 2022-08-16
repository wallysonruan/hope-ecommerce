package dc.hope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dc.hope.models.Produtos;

public interface ProdutosRepository extends JpaRepository <Produtos, Long> {

	List<Produtos> findByNomeContainingIgnoreCase(String nome);
	List<Produtos> findByNomeContainingIgnoreCaseOrderByPrecoAsc(String nome);
	List<Produtos> findByNomeContainingIgnoreCaseOrderByPrecoDesc(String nome);
}
