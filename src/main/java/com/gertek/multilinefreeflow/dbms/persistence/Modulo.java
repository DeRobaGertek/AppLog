package com.gertek.multilinefreeflow.dbms.persistence;

import java.io.Serializable;

/**
 * @author Raul 18 de abr. de 2017
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
public class Modulo implements Serializable,Comparable<Modulo>{
	/* Constate del serial de la clase.*/
	private static final long serialVersionUID = 1L;
	/* Constante para id nulo.*/
	public final static int CODIGO_NULO = -1;
	
	/* ***** Atributos del 'Modulo'.*********/
	private int id;
	private String codigo;
	private String descripcion;

	/**
	 * <p>Constructor vacio de la clase pojo 'Modulo'.</p>
	 */
	public Modulo() {
		/* Constructor del padre.*/
		super();
		/* Se asigna por defecto identificador nulo.*/
		this.id = CODIGO_NULO;
		/* Se inicializan los atributos.*/
		this.codigo = "";
		this.descripcion = "";		
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
	 * @return codigo. Se devuelve el atributo "codigo".
	 */
	
	public String getCodigo() {
		/* Se devuelve el valor del atributo "codigo". */
		return codigo;
	}

	/**
	 * @param codigo. Se asigna valor al atributo "codigo".
	 */
	public void setCodigo(String codigo) {
		/* Se asigna el valor del atributo "codigo" pasado por parametro. */
		this.codigo = codigo;
	}

	/**
	 * @return descripcion. Se devuelve el atributo "descripcion".
	 */
	
	public String getDescripcion() {
		/* Se devuelve el valor del atributo "descripcion". */
		return descripcion;
	}

	/**
	 * @param descripcion. Se asigna valor al atributo "descripcion".
	 */
	public void setDescripcion(String descripcion) {
		/* Se asigna el valor del atributo "descripcion" pasado por parametro. */
		this.descripcion = descripcion;
	}


	@Override
	/**
	 * @return String
	 * 
	 * <p> Metodo que devuelve la clase covertida a cadena de caracteres.</p>
	 * */
	public String toString() {				
		/* Se devuelve los atributos de la clase.*/
		return " Id " + this.id + " Codigo : " + this.codigo +
			   "Descripción : " + this.descripcion;
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
			if (obj instanceof Modulo){
				/* Se compara los identificadores de la clase actual y 
				 * el 'Módulo' recibido por parametro.*/
				resultado =  this.getId()== ((Modulo) obj).getId();
			}
				
		}
		/* Se devuelve el resultado de la comparación.*/			
		return resultado;
	}

	/**
	 * @param Modulo
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
	public int compareTo(Modulo modulo) {
		/* Se devuelve la comparación del nombre de la clase y 
		 * el 'Módulo' recibido por parametro.*/
		return this.getCodigo().compareToIgnoreCase(modulo.getCodigo());
	}	
}
