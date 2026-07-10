package com.ibcegos.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home/")
public class HomeController { // controlleur
	
	@RequestMapping("/index")
	//@ResponseBody
	// Une action(méthode) qui renvois vers une vue (interface) welcome.html
	public String welcome() {
		//return "<h1 align=center>view welcome</h1>"; 
		return "home/bienvenue.html"; 
	}
	
	@RequestMapping("/apropos")
	//@ResponseBody
	// Une action(méthode) qui renvois vers une vue (interface) apropos.html
	public String apropos() {
		//return "<h1 align=center>view welcome</h1>"; 
		return "home/apropos.html"; 
	}
	
	@RequestMapping("/formations")
	// Une action(méthode) qui renvois vers une vue (interface) formations.html
	public String formations() {
		return "home/formations.html"; 
	}


}
