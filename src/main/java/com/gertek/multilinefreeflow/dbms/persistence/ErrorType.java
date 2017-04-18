package com.gertek.multilinefreeflow.dbms.persistence;

import java.io.Serializable;

/**
 * @author Raul 18 de abr. de 2017
 *
 * <p> Clase Pojo que contendrá al objeto 'Tipo de Error'. </p>
 * <p> Se contenplan los diferentes errores y/o excepciones que se van a trazar. </p>
 * <p> Inicialmente se trabajara con los códigos de error de Oracle,
 *     aunque se podrán añadir tipos de errores propios en un futuro. </p>
 * 
 * <p>Los atributos de la clase serán : <p>
  * <ul>
 * 		<li>id : Identificador Interno.</li>
 * 		<li>codigo : Código alfanumerico del error.</li>
 * 		<li>descripcion : Detalle del error.</li>
 * </ul>
 *
 */
public class ErrorType implements Serializable,Comparable<ErrorType>{
	/* Constate del serial de la clase.*/
	private static final long serialVersionUID = 1L;
	/* Constante para id nulo.*/
	public final static int CODIGO_NULO = -1;
	
	/* ***** Atributos del 'Tipo de Error'.*********/
	private int id;
	private String code;
	private String description;

	/**
	 * <p>Constructor vacio de la clase pojo 'Tipo de Error'.</p>
	 */
	public ErrorType() {
		/* Constructor del padre.*/
		super();
		/* Se asigna por defecto identificador nulo.*/
		this.id = CODIGO_NULO;
		/* Se inicializan los atributos.*/
		this.code = "";
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
	 * @return code. Se devuelve el atributo "code".
	 */
	
	public String getCode() {
		/* Se devuelve el valor del atributo "code". */
		return code;
	}

	/**
	 * @param code. Se asigna valor al atributo "code".
	 */
	public void setCode(String code) {
		/* Se asigna el valor del atributo "code" pasado por parametro. */
		this.code = code;
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
		return " Id " + this.id + " Codigo : " + this.code +
			   "Descripción : " + this.description;
	}
	
	/** 
	 * <p> Se obtiene la un código Hash para 
	 *     la clase 'Tipo de Error' en base a su 'id'.</p>
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
			 * la clase 'Tipo de Error'.*/
			if (obj instanceof ErrorType){
				/* Se compara los identificadores de la clase actual y 
				 * el tipo de error recibido por parametro.*/
				resultado =  this.getId()== ((ErrorType) obj).getId();
			}
				
		}
		/* Se devuelve el resultado de la comparación.*/			
		return resultado;
	}

	/**
	 * @param Tipo Error
	 * @return int
	 * 
	 * <p> Se usa en el caso de ordenamiento de List o Array. </p>
	 * <ul>
	 * 	<li> -1 Indicará que la clase es menor al tipo de error recibido por parametro. </li>
	 * 	<li> 0 Indicará que la clase es igual al tipo de error recibido por parametro. </li>
	 * 	<li> 1 Indicará que la clase es mayor al tipo de error recibido por parametro. </li>
	 * </ul>
	 * 
	 */
	public int compareTo(ErrorType tipoError) {
		/* Se devuelve la comparación del nombre de la clase y 
		 * el tipo de error recibido por parametro.*/
		return this.getCode().compareToIgnoreCase(tipoError.getCode());
	}	
}
