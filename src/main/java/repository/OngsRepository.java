package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Ongs;

public interface OngsRepository extends JpaRepository <Ongs, Long> {
    
}
