package com.afi.springboot1.service;

import java.util.List;
import java.util.Optional;

import com.afi.springboot1.entity.User;

public interface UserInterface {

	public void ajouter(User u);
	public void modifier(User u);
	public void supprimer(Long id);
	public List<User> afficher();
	public User rechercher(Long id);
	public Iterable<User> rechercheParNom(String nom);
	public User testLogin(String login, String password);
}
