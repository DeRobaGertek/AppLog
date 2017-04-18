package com.gertek.multilinefreeflow.dbms.persistence;

import java.io.Serializable;

/**
 * @author Raul 18 de abr. de 2017
 *
 * <p> Clase Pojo que contendrá al objeto 'Usuario'. </p>
 * <p> Se contenplan los diferentes usuarios que han lanzado 
 *     el proceso que ha generado la traza. </p>
 * <p> Existirá un usaurio '0' para los procesos que se lancen sin usuario.</p>
 * 
 * <p>Los atributos de la clase serán : <p>
  * <ul>
 * 		<li>id : Identificador Interno.</li>
 * 		<li>nombre : Nombre de usuario.</li>
 * 		<li>descripción : Descripción del usuario.</li>
 * </ul>
 *
 */
public class User implements Serializable,Comparable<User>{
	/* Constate del serial de la clase.*/
	private static final long serialVersionUID = 1L;
	/* Constante para id nulo.*/
	public final static int CODIGO_NULO = -1;
	
	/* ***** Atributos del 'Usuario'.*********/
	private int id;
	private String name;
	private String description;

	/**
	 * <p>Constructor vacio de la clase pojo 'Usuario'.</p>
	 */
	public User() {
		/* Constructor del padre.*/
		super();
		/* Se asigna por defecto identificador nulo.*/
		this.id = CODIGO_NULO;
		/* Se inicializan los atributos.*/
		this.name = "";
		this.description = "";		
	}	
	
	/**
	 * @return id. Se devuelve el atributo "id".
	 */
	
	public int getId() {
		/* Se devuelve el valor del atributo "id". */
		return id;
	}

	/**
	 * @param id. Se asigna valor al atributo "id".
	 */
	public void setId(int id) {
		/* Se asigna el valor del atributo "id" pasado por parametro. */
		this.id = id;
	}

	/**
	 * @return name. Se devuelve el atributo "name".
	 */
	
	public String getName() {
		/* Se devuelve el valor del atributo "name". */
		return name;
	}

	/**
	 * @param name. Se asigna valor al atributo "name".
	 */
	public void setName(String name) {
		/* Se asigna el valor del atributo "name" pasado por parametro. */
		this.name = name;
	}

	/**
	 * @return description. Se devuelve el atributo "description".
	 */
	
	public String getDescription() {
		/* Se devuelve el valor del atributo "description". */
		return description;
	}

	/**
	 * @param description. Se asigna valor al atributo "description".
	 */
	public void setDescription(String description) {
		/* Se asigna el valor del atributo "description" pasado por parametro. */
		this.description = description;
	}

	@Override
	/**
	 * @return String
	 * 
	 * <p> Metodo que devuelve la clase covertida a cadena de caracteres.</p>
	 * */
	public String toString() {				
		/* Se devuelve los atributos de la clase.*/
		return " Id " + this.id + " Nombre : " + this.name +
			   "Descripción : " + this.description;
	}
	
	/** 
	 * <p> Se obtiene la un código Hash para 
	 *     la clase 'Usuario' en base a su 'id'.</p>
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}

	/** 
	 * <p> Metodo que compara si dos objetos son iguales. </p>
	 */
	@Override
	public boolean equals(Object obj) {
		/* Se declara e inicializa una variable para devolver 
		 * el resultado de la comparación.*/
		boolean resultado = false;
		/* Se comprueba que el objeto pasado por paramtro no sea nulo.*/
		if (obj != null){
			/* Se comprueba si el objeto pasado por parametro es de 
			 * la clase 'Usuario'.*/
			if (obj instanceof User){
				/* Se compara los identificadores de la clase actual y 
				 * al usuario recibido por parametro.*/
				resultado =  this.getId()== ((User) obj).getId();
			}
				
		}
		/* Se devuelve el resultado de la comparación.*/			
		return resultado;
	}

	/**
	 * @param User
	 * @return int
	 * 
	 * <p> Se usa en el caso de ordenamiento de List o Array. </p>
	 * <ul>
	 * 	<li> -1 Indicará que la clase es menor al usuario recibido por parametro. </li>
	 * 	<li> 0 Indicará que la clase es igual al usuario recibido por parametro. </li>
	 * 	<li> 1 Indicará que la clase es mayor al usuario recibido por parametro. </li>
	 * </ul>
	 * 
	 */
	public int compareTo(User usuario) {
		/* Se devuelve la comparación del nombre de la clase y 
		 * al usuario recibido por parametro.*/
		return this.getName().compareToIgnoreCase(usuario.getName());
	}	
}
