package dc.hope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dc.hope.models.Ongs;

public interface OngsRepository extends JpaRepository <Ongs, Long> {
    
}
