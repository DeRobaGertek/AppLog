package com.gertek.multilinefreeflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Raúl De Roba 18 de abr. de 2017
 *
 * <p> Clase que se encarga de direccionar todas las peticiones del proyecto,
 *     (salvo las que tengan un controlador propio). </p>
 *
 */
/* @Controller Se indica que es una clase de tipo controlador.
 * @RequestMapping Se indica el tipo de peticiones que va a gestionar. 
 *                 Con el parametro '/' se indica que por defecto se 
 *                 trataran todas las peticiones.*/
@Controller
@RequestMapping(value = "/")
public class HomeController {

	/* Metodo que gestionará las peticiones GET.*/
	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		/* Se redirige a 'index.jsp'*/
		return "index";
	}
	
}
