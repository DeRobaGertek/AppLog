package com.gertek.multilinefreeflow.dtto;

import java.io.Serializable;

/**
 * @author Raúl De Roba 18 de abr. de 2017
 *
 * <p> Clase Pojo que contendrá al objeto 'Modulo'. </p>
 * <p> Se contenplan los diferentes modulos del proyecto que podrán generar 
 *     los logs a estudiar. </p>
 * <p> Inicialmente se trabajara con los modulos 
 *     'Auditoría de Tránsitos' y 'Armado de Trayectos', 
 *     aunque en el futuro se contempla gestionar todo el proyecto 
 *     'Multi line Free Flow'. </p>
 * 
 * <p>Los atributos de la clase serán : <p>
  * <ul>
 * 		<li>id : Identificador Interno.</li>
 * 		<li>codigo : Código alfanumerico del proyecto.</li>
 * 		<li>descripcion : Detalle del módulo.</li>
 * </ul>
 *
 */
public class AppModule implements Serializable,Comparable<AppModule>{
	/* Constate del serial de la clase.*/
	private static final long serialVersionUID = 1L;
	/* Constante para id nulo.*/
	public final static int CODIGO_NULO = -1;
	
	/* ***** Atributos del 'Modulo'.*********/
	private int id;
	private String code;
	private String description;

	/**
	 * <p>Constructor vacio de la clase pojo 'Modulo'.</p>
	 */
	public AppModule() {
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
	 *     la clase 'Modulo' en base a su 'id'.</p>
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
			 * la clase 'Modulo'.*/
			if (obj instanceof AppModule){
				/* Se compara los identificadores de la clase actual y 
				 * el 'Módulo' recibido por parametro.*/
				resultado =  this.getId()== ((AppModule) obj).getId();
			}
				
		}
		/* Se devuelve el resultado de la comparación.*/			
		return resultado;
	}

	/**
	 * @param AppModule
	 * @return int
	 * 
	 * <p> Se usa en el caso de ordenamiento de List o Array. </p>
	 * <ul>
	 * 	<li> -1 Indicará que la clase es menor al 'Módulo' recibido por parametro. </li>
	 * 	<li> 0 Indicará que la clase es igual al 'Módulo' recibido por parametro. </li>
	 * 	<li> 1 Indicará que la clase es mayor al 'Módulo' recibido por parametro. </li>
	 * </ul>
	 * 
	 */
	public int compareTo(AppModule modulo) {
		/* Se devuelve la comparación del nombre de la clase y 
		 * el 'Módulo' recibido por parametro.*/
		return this.getCode().compareToIgnoreCase(modulo.getCode());
	}	
}
