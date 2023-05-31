package com.afi.springboot1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.afi.springboot1.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, Long>{

}
