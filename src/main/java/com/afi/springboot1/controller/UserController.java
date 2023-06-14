package com.afi.springboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.afi.springboot1.entity.User;
import com.afi.springboot1.service.UserService;

@Component
@Controller
public class UserController {

	@Autowired
	UserService us;
	
	@GetMapping("/")
	public String homepage(Model model) {
		model.addAttribute("user", new User());
		return "admin/auth/welcome";
	}
	
	@GetMapping("/newUser")
	public String showRegisterPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "admin/auth/newUser";
	}
	
	@PostMapping("/newUser/save")
	public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
		us.ajouter(user);
		return "redirect:/newUser?Success";
	}
	
	@GetMapping(path="/liste")
	public String showListUser(Model model) {
		model.addAttribute("AllUserList", us.afficher());
		return "admin/auth/listeUser";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteById(@PathVariable(value="id") long id) {
		
		us.supprimer(id);
		return "redirect:/liste";
	}
	
	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateForm(Model model, @PathVariable("id") long id) {
		User user = us.rechercher(id);
		model.addAttribute("user", user);
		
		return "admin/auth/updateUser";
	}
	
	// presente les resultats de recherche
	@GetMapping("/rechercheParNom/nom")
	public String listeParNom(@ModelAttribute("user") User user, BindingResult result, Model model) {
		model.addAttribute("UserList", us.rechercheParNom(user.getNom()));
		return "admin/auth/listeParNom";
	}
	
	// affiche le formulaire de recherche
	@GetMapping("/nom")
	public String viewSearchForm(Model model) {
		model.addAttribute("user", new User());
		return "admin/auth/rechercheParNom";
	}
	
	@GetMapping("/login")
	public String viewLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "admin/auth/login";
	}
	
	@GetMapping("/login/testLogin")
	public String connexion(@ModelAttribute("user") User user, BindingResult result, Model model) {
		User u = null;
		u = us.testLogin(user.getLogin(), user.getPassword());
		
		if(u == null) {
			return "redirect:/login";
		} else {
			return "redirect:/liste";
		}
	}
}
