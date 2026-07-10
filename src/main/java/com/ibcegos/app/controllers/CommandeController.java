package com.ibcegos.app.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/commande/")
public class CommandeController {
	
	
	@RequestMapping("/list")
	//@ResponseBody
	// Une action(méthode) qui renvois vers une vue (interface) welcome.html
	public String listeCommandes() {
		//return "<h1 align=center>view welcome</h1>"; 
		return "commande/listcommandes.html"; 
	}

}
