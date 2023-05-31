package com.afi.springboot1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.afi.springboot1.entity.User;
import com.afi.springboot1.repository.UserRepository;

@Component
@ComponentScan("com.afi.springboot1.repository")
@Service
public class UserService implements UserInterface{

	@Autowired
	UserRepository ur;
	
	@Override
	public void ajouter(User u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public void modifier(User u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		ur.deleteById(id);
	}

	@Override
	public List<User> afficher() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public User rechercher(Long id) {
		// TODO Auto-generated method stub
		User u = null;
		Optional<User> op = ur.findById(id);
		
		if(op.isPresent()) {
			u = op.get();
		} else {
			throw new RuntimeException("User not found");
		}
		return u;
	}

}
