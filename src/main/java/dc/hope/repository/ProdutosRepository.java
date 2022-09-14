package dc.hope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dc.hope.models.Produto;

public interface ProdutosRepository extends JpaRepository <Produto, Long> {

	List<Produto> findByNomeContainingIgnoreCase(String nome);
	List<Produto> findByNomeContainingIgnoreCaseOrderByPrecoAsc(String nome);
	List<Produto> findByNomeContainingIgnoreCaseOrderByPrecoDesc(String nome);
}
