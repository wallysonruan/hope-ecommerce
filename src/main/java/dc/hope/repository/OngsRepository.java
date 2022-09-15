package dc.hope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import dc.hope.models.Ong;

public interface OngsRepository extends JpaRepository <Ong, Long> {
  List<Ong> findByNomeContainingIgnoreCase(String nome);
}
