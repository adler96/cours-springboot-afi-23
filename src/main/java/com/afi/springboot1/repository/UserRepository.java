package com.afi.springboot1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.afi.springboot1.entity.User;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long>{

	// recherche en fonction du nom
	public Iterable<User> findByNom(String nom); 
}
