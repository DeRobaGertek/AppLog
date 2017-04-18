package com.gertek.multilinefreeflow.dbms.persistence;

import java.io.Serializable;
import java.util.Date;

import com.gertek.multilinefreeflow.util.Utils;

/**
 * @author Raul 18 de abr. de 2017
 *
 * <p> Clase Pojo que contendrá al objeto 'Auditoria'. </p>
 * <p> En la clase auditoria se registrarán las trazas que se registren en la base de datos 
 *    dentro del proyecto AppLog;por lo tanto se convertirá en el historico de trazas y 
 *    como consecuencia la entidad principal de la aplciación 'AppLog'. </p>
 * 
 * <p>Los atributos de la clase serán : <p>
  * <ul>
 * 		<li>id : Identificador Interno.</li>
 * 		<li>fecha : Fecha completa (Fecha,hora y zona horaria) 
 *                  en que se registra la traza.</li>
 * 		<li>nivel de traza : Nivel de traza registrado (vease clase NivelTraza).</li>
 * 		<li>modulo : Módulo en que se produce la traza (vease clase Modulo).</li> 
 * 		<li>procedimiento : Procedimiento almacenado que produce la traza.</li>  
 * 		<li>parametros : Parametros que recibie el procedimiento almacenado que 
 *                       produce la traza.</li>  
 * 		<li>texto : Texto asociado a la traza. 
 *                  (Codificado en el procediiento almacenado).</li>   
 * 		<li>tipoError : Tipo de error trazado y registrado.(vease clase TipoError).</li> 
 * 		<li>usuario : Usuario que lanza el proceso quye ah su vez ha lanzado 
 *                    el procedimiento almacenado que ha regsitrado la traza.
 *                    (vease clase Usuario).</li>      
 *      <li>sesion : Identificador de la sesión en que se produce la traza. 
 *                   (Siempre la traza se haya producido en un proceso con sesión).</li>   
 * </ul>
 *
 */
public class Auditoria implements Serializable,Comparable<Auditoria>{
	/* Constate del serial de la clase.*/
	private static final long serialVersionUID = 1L;
	/* Constante para id nulo.*/
	public final static int CODIGO_NULO = -1;
	
	/* ***** Atributos del 'Auditoria'.*********/
	private int id;
	private Date fecha;
	private LogLevel nivelTraza;
	private Modulo modulo;
	private String procedimiento;
	private String parametros;
	private String texto;
	private ErrorType tipoError;
	private User usuario;
	private String sesion;

	/**
	 * <p>Constructor vacio de la clase pojo 'Auditoria'.</p>
	 */
	public Auditoria() {
		/* Constructor del padre.*/
		super();
		/* Se asigna por defecto identificador nulo.*/
		this.id = CODIGO_NULO;
		/* Se inicializan los atributos.*/
		this.fecha = new Date();
		this.nivelTraza = null;
		this.modulo = null;
		this.procedimiento= "";
		this.parametros = "";
		this.texto="";
		this.tipoError=null;
		this.usuario=null;
		this.sesion="";	
	}	
	
	

	/**
	 * @param LogLevel nivelTraza, 
	 * @param Modulo modulo, 
	 * @param String procedimiento, 
	 * @param String parametros, 
	 * @param String texto,
	 * @param ErrorType tipoError, 
	 * @param User usuario, 
	 * @param String
	 * 
	 * <p>Constructor de la clase pojo 'Auditoria' con los parametros más habituales.</p>
	 */
	public Auditoria(LogLevel nivelTraza, 
			         Modulo modulo, 
			         String procedimiento, 
			         String parametros, 
			         String texto,
			         ErrorType tipoError, 
			         User usuario, 
			         String sesion) {
		/* Constructor del padre.*/
		super();
		/* Se asigna por defecto identificador nulo.*/
		this.id = CODIGO_NULO;
		/* Se inicializan la fecha con la fecha del sistema.*/
		this.fecha = new Date();
		/* Se inicializan los atributos con los parametros recibidos.*/
		this.nivelTraza = nivelTraza;
		this.modulo = modulo;
		this.procedimiento = procedimiento;
		this.parametros = parametros;
		this.texto = texto;
		this.tipoError = tipoError;
		this.usuario = usuario;
		this.sesion = sesion;
	}
	
	/**
	 * @param Date fecha
	 * @param LogLevel nivelTraza, 
	 * @param Modulo modulo, 
	 * @param String procedimiento, 
	 * @param String parametros, 
	 * @param String texto,
	 * @param ErrorType tipoError, 
	 * @param User usuario, 
	 * @param String
	 * <p>Constructor de la clase pojo 'Auditoria' con los todos los parametros.</p>
	 */
	public Auditoria(Date fecha,
			         LogLevel nivelTraza, 
			         Modulo modulo, 
			         String procedimiento, 
			         String parametros, 
			         String texto,
			         ErrorType tipoError, 
			         User usuario, 
			         String sesion) {
		/* Constructor del padre.*/
		super();
		/* Se asigna por defecto identificador nulo.*/
		this.id = CODIGO_NULO;
		/* Se inicializan los atributos con los parametros recibidos.*/
		this.fecha = fecha;
		this.nivelTraza = nivelTraza;
		this.modulo = modulo;
		this.procedimiento = procedimiento;
		this.parametros = parametros;
		this.texto = texto;
		this.tipoError = tipoError;
		this.usuario = usuario;
		this.sesion = sesion;
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
	 * @return fecha. Se devuelve el atributo "fecha".
	 */
	
	public Date getFecha() {
		/* Se devuelve el valor del atributo "fecha". */
		return fecha;
	}

	/**
	 * @param fecha. Se asigna valor al atributo "fecha".
	 */
	public void setFecha(Date fecha) {
		/* Se asigna el valor del atributo "fecha" pasado por parametro. */
		this.fecha = fecha;
	}

	/**
	 * @return nivelTraza. Se devuelve el atributo "nivelTraza".
	 */
	
	public LogLevel getNivelTraza() {
		/* Se devuelve el valor del atributo "nivelTraza". */
		return nivelTraza;
	}

	/**
	 * @param nivelTraza. Se asigna valor al atributo "nivelTraza".
	 */
	public void setNivelTraza(LogLevel nivelTraza) {
		/* Se asigna el valor del atributo "nivelTraza" pasado por parametro. */
		this.nivelTraza = nivelTraza;
	}

	/**
	 * @return modulo. Se devuelve el atributo "modulo".
	 */
	
	public Modulo getModulo() {
		/* Se devuelve el valor del atributo "modulo". */
		return modulo;
	}

	/**
	 * @param modulo. Se asigna valor al atributo "modulo".
	 */
	public void setModulo(Modulo modulo) {
		/* Se asigna el valor del atributo "modulo" pasado por parametro. */
		this.modulo = modulo;
	}

	/**
	 * @return procedimiento. Se devuelve el atributo "procedimiento".
	 */
	
	public String getProcedimiento() {
		/* Se devuelve el valor del atributo "procedimiento". */
		return procedimiento;
	}

	/**
	 * @param procedimiento. Se asigna valor al atributo "procedimiento".
	 */
	public void setProcedimiento(String procedimiento) {
		/* Se asigna el valor del atributo "procedimiento" pasado por parametro. */
		this.procedimiento = procedimiento;
	}

	/**
	 * @return parametros. Se devuelve el atributo "parametros".
	 */
	
	public String getParametros() {
		/* Se devuelve el valor del atributo "parametros". */
		return parametros;
	}

	/**
	 * @param parametros. Se asigna valor al atributo "parametros".
	 */
	public void setParametros(String parametros) {
		/* Se asigna el valor del atributo "parametros" pasado por parametro. */
		this.parametros = parametros;
	}

	/**
	 * @return texto. Se devuelve el atributo "texto".
	 */
	
	public String getTexto() {
		/* Se devuelve el valor del atributo "texto". */
		return texto;
	}

	/**
	 * @param texto. Se asigna valor al atributo "texto".
	 */
	public void setTexto(String texto) {
		/* Se asigna el valor del atributo "texto" pasado por parametro. */
		this.texto = texto;
	}

	/**
	 * @return tipoError. Se devuelve el atributo "tipoError".
	 */
	
	public ErrorType getTipoError() {
		/* Se devuelve el valor del atributo "tipoError". */
		return tipoError;
	}

	/**
	 * @param tipoError. Se asigna valor al atributo "tipoError".
	 */
	public void setTipoError(ErrorType tipoError) {
		/* Se asigna el valor del atributo "tipoError" pasado por parametro. */
		this.tipoError = tipoError;
	}

	/**
	 * @return usuario. Se devuelve el atributo "usuario".
	 */
	
	public User getUsuario() {
		/* Se devuelve el valor del atributo "usuario". */
		return usuario;
	}

	/**
	 * @param usuario. Se asigna valor al atributo "usuario".
	 */
	public void setUsuario(User usuario) {
		/* Se asigna el valor del atributo "usuario" pasado por parametro. */
		this.usuario = usuario;
	}

	/**
	 * @return sesion. Se devuelve el atributo "sesion".
	 */
	
	public String getSesion() {
		/* Se devuelve el valor del atributo "sesion". */
		return sesion;
	}

	/**
	 * @param sesion. Se asigna valor al atributo "sesion".
	 */
	public void setSesion(String sesion) {
		/* Se asigna el valor del atributo "sesion" pasado por parametro. */
		this.sesion = sesion;
	}

	@Override
	/**
	 * @return String
	 * 
	 * <p> Metodo que devuelve la clase covertida a cadena de caracteres.</p>
	 * */
	public String toString() {				
		/* Se devuelve los atributos de la clase.*/
		return " Id " + this.id + " Fecha : " + Utils.parseDateString(this.fecha) + 
               " Nivel Traza : " + this.nivelTraza.getCodigo() +
		       " Módulo : " + this.modulo +
		       " Procedimiento : " + this.procedimiento +
		       " Texto : " + this.texto +
		       " Tipo Error : " + this.tipoError.getCodigo() +
		       " Usuario : " + this.usuario.getNombre() +
		       " Parámetros : " + this.parametros +
		       " Sesión : " + this.sesion;
	}
	
	/** 
	 * <p> Se obtiene la un código Hash para 
	 *     la clase 'Auditoria' en base a su 'id'.</p>
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
			if (obj instanceof Auditoria){
				/* Se compara los identificadores de la clase actual y 
				 * la 'Auditoria' recibida por parametro.*/
				resultado =  this.getId()== ((Auditoria) obj).getId();
			}
				
		}
		/* Se devuelve el resultado de la comparación.*/			
		return resultado;
	}

	/**
	 * @param Auditoria
	 * @return int
	 * 
	 * <p> Se usa en el caso de ordenamiento de List o Array. </p>
	 * <ul>
	 * 	<li> -1 Indicará que la clase es menor a la 'Auditoria' recibida por parametro. </li>
	 * 	<li> 0 Indicará que la clase es igual a la 'Auditoria' recibida por parametro. </li>
	 * 	<li> 1 Indicará que la clase es mayor a la 'Auditoria' recibida por parametro. </li>
	 * </ul>
	 * 
	 */
	public int compareTo(Auditoria auditoria) {
		/* Se devuelve la comparación del nombre de la clase y 
		 * la 'Auditoria' recibida por parametro.*/
		return Utils.parseDateString(this.fecha).compareToIgnoreCase(Utils.parseDateString(auditoria.getFecha()));
	}	
}
