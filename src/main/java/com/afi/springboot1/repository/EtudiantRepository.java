package com.afi.springboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.afi.springboot1.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

	
}
