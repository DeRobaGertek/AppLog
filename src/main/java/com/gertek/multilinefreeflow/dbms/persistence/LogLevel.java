package com.gertek.multilinefreeflow.dbms.persistence;

import java.io.Serializable;

/**
 * @author Raúl De Roba 18 de abr. de 2017
 *
 * <p> Clase Pojo que contendrá al objeto 'Nivel de Traza'. </p>
 * <p> Se contenpla poder clasificar por niveles de traza tal y como hace Log4Java.
 * 	   Inicialmente se clasificará en  : </p>
 * <ul>
 * 		<li>OFF	  0</li>
 * 		<li>FATAL 100</li>
 * 		<li>ERROR 200</li>
 * 		<li>WARN  300</li>
 * 		<li>INFO  400</li>
 * 		<li>DEBUG 500</li>
 * 		<li>TRACE 600</li>
 * 		<li>ALL Max</li>
 * </ul>
 * <p>Según se requiera se podrán añadir nuevos niveles en el futuro. </p>
 * 
 * <p>Los atributos de la clase serán : <p>
  * <ul>
 * 		<li>id : Identificador Interno.</li>
 * 		<li>codigo : Código alfanumerico que inetificará el nivel de traza.
 *         (OFF,FATAL,ERROR,...)</li>
 * 		<li>Nivel : Númerico que indica el nivel de la traza, de manerá que al filtrar una traza
 *                  se consideraá las trazas del mismo nivel y superiores.</li>
 * 		<li>descripcion : Detalle del nivel de traza.</li>
 * </ul>
 *
 */
public class LogLevel implements Serializable,Comparable<LogLevel>{
	/* Constate del serial de la clase.*/
	private static final long serialVersionUID = 1L;
	/* Constante para id nulo.*/
	public final static int CODIGO_NULO = -1;
	
	/* ***** Atributos del 'Nivel de Traza'.*********/
	private int id;
	private String code;
	private int level;
	private String description;

	/**
	 * <p>Constructor vacio de la clase pojo 'Nivel de Traza'.</p>
	 */
	public LogLevel() {
		/* Constructor del padre.*/
		super();
		/* Se asigna por defecto identificador nulo.*/
		this.id = CODIGO_NULO;
		/* Se inicializan los atributos.*/
		this.code = "";
		this.level = 0;
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
	 * @return level. Se devuelve el atributo "level".
	 */
	
	public int getLevel() {
		/* Se devuelve el valor del atributo "level". */
		return level;
	}

	/**
	 * @param level. Se asigna valor al atributo "level".
	 */
	public void setLevel(int level) {
		/* Se asigna el valor del atributo "level" pasado por parametro. */
		this.level = level;
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
			   " Nivel : " + this.level + "Descripción : " + this.description;
	}
	
	/** 
	 * <p> Se obtiene la un código Hash para 
	 *     la clase 'Nivel de Traza' en base a su 'id'.</p>
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
			 * la clase 'Nivel de Traza'.*/
			if (obj instanceof LogLevel){
				/* Se compara los identificadores de la clase actual y 
				 * el 'nivel de traza' recibido por parametro.*/
				resultado =  this.getId()== ((LogLevel) obj).getId();
			}
				
		}
		/* Se devuelve el resultado de la comparación.*/			
		return resultado;
	}

	/**
	 * @param LogLevel
	 * @return int
	 * 
	 * <p> Se usa en el caso de ordenamiento de List o Array. </p>
	 * <ul>
	 * 	<li> -1 Indicará que la clase es menor al 'nivel de traza' recibido por parametro. </li>
	 * 	<li> 0 Indicará que la clase es igual al 'nivel de traza' recibido por parametro. </li>
	 * 	<li> 1 Indicará que la clase es mayor al 'nivel de traza' recibido por parametro. </li>
	 * </ul>
	 * 
	 */
	public int compareTo(LogLevel nivelTraza) {
		/* Se devuelve la comparación del nombre de la clase y 
		 * el 'nivel de traza' recibido por parametro.*/
		return this.getCode().compareToIgnoreCase(nivelTraza.getCode());
	}	
}
