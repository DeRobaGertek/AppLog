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
public class Audit implements Serializable,Comparable<Audit>{
	/* Constate del serial de la clase.*/
	private static final long serialVersionUID = 1L;
	/* Constante para id nulo.*/
	public final static int CODIGO_NULO = -1;
	
	/* ***** Atributos del 'Auditoria'.*********/
	private int id;
	private Date date;
	private LogLevel logLevel;
	private AppModule appModule;
	private String functionName;
	private String parameters;
	private String text;
	private ErrorType ErrorType;
	private User user;
	private String sessionId;

	/**
	 * <p>Constructor vacio de la clase pojo 'Auditoria'.</p>
	 */
	public Audit() {
		/* Constructor del padre.*/
		super();
		/* Se asigna por defecto identificador nulo.*/
		this.id = CODIGO_NULO;
		/* Se inicializan los atributos.*/
		this.date = new Date();
		this.logLevel = null;
		this.appModule = null;
		this.functionName= "";
		this.parameters = "";
		this.text="";
		this.ErrorType=null;
		this.user=null;
		this.sessionId="";	
	}	
	
	

	/**
	 * @param LogLevel nivelTraza, 
	 * @param AppModule modulo, 
	 * @param String procedimiento, 
	 * @param String parametros, 
	 * @param String texto,
	 * @param ErrorType tipoError, 
	 * @param User usuario, 
	 * @param String
	 * 
	 * <p>Constructor de la clase pojo 'Auditoria' con los parametros más habituales.</p>
	 */
	public Audit(LogLevel nivelTraza, 
			         AppModule modulo, 
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
		this.date = new Date();
		/* Se inicializan los atributos con los parametros recibidos.*/
		this.logLevel = nivelTraza;
		this.appModule = modulo;
		this.functionName = procedimiento;
		this.parameters = parametros;
		this.text = texto;
		this.ErrorType = tipoError;
		this.user = usuario;
		this.sessionId = sesion;
	}
	
	/**
	 * @param Date fecha
	 * @param LogLevel nivelTraza, 
	 * @param AppModule modulo, 
	 * @param String procedimiento, 
	 * @param String parametros, 
	 * @param String texto,
	 * @param ErrorType tipoError, 
	 * @param User usuario, 
	 * @param String
	 * <p>Constructor de la clase pojo 'Auditoria' con los todos los parametros.</p>
	 */
	public Audit(Date fecha,
			         LogLevel nivelTraza, 
			         AppModule modulo, 
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
		this.date = fecha;
		this.logLevel = nivelTraza;
		this.appModule = modulo;
		this.functionName = procedimiento;
		this.parameters = parametros;
		this.text = texto;
		this.ErrorType = tipoError;
		this.user = usuario;
		this.sessionId = sesion;
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
	 * @return date. Se devuelve el atributo "date".
	 */	
	public Date getDate() {
		/* Se devuelve el valor del atributo "date". */
		return date;
	}

	/**
	 * @param date. Se asigna valor al atributo "date".
	 */
	public void setDate(Date date) {
		/* Se asigna el valor del atributo "date" pasado por parametro. */
		this.date = date;
	}

	/**
	 * @return logLevel. Se devuelve el atributo "logLevel".
	 */	
	public LogLevel getLogLevel() {
		/* Se devuelve el valor del atributo "logLevel". */
		return logLevel;
	}

	/**
	 * @param logLevel. Se asigna valor al atributo "logLevel".
	 */
	public void setLogLevel(LogLevel logLevel) {
		/* Se asigna el valor del atributo "logLevel" pasado por parametro. */
		this.logLevel = logLevel;
	}

	/**
	 * @return appModule. Se devuelve el atributo "appModule".
	 */	
	public AppModule getAppModule() {
		/* Se devuelve el valor del atributo "appModule". */
		return appModule;
	}

	/**
	 * @param appModule. Se asigna valor al atributo "appModule".
	 */
	public void setAppModule(AppModule appModule) {
		/* Se asigna el valor del atributo "appModule" pasado por parametro. */
		this.appModule = appModule;
	}

	/**
	 * @return functionName. Se devuelve el atributo "functionName".
	 */	
	public String getFunctionName() {
		/* Se devuelve el valor del atributo "functionName". */
		return functionName;
	}

	/**
	 * @param functionName. Se asigna valor al atributo "functionName".
	 */
	public void setFunctionName(String functionName) {
		/* Se asigna el valor del atributo "functionName" pasado por parametro. */
		this.functionName = functionName;
	}

	/**
	 * @return parameters. Se devuelve el atributo "parameters".
	 */
	
	public String getParameters() {
		/* Se devuelve el valor del atributo "parameters". */
		return parameters;
	}

	/**
	 * @param parameters. Se asigna valor al atributo "parameters".
	 */
	public void setParameters(String parameters) {
		/* Se asigna el valor del atributo "parameters" pasado por parametro. */
		this.parameters = parameters;
	}

	/**
	 * @return text. Se devuelve el atributo "text".
	 */
	
	public String getText() {
		/* Se devuelve el valor del atributo "text". */
		return text;
	}

	/**
	 * @param text. Se asigna valor al atributo "text".
	 */
	public void setText(String text) {
		/* Se asigna el valor del atributo "text" pasado por parametro. */
		this.text = text;
	}

	/**
	 * @return errorType. Se devuelve el atributo "errorType".
	 */
	
	public ErrorType getErrorType() {
		/* Se devuelve el valor del atributo "ErrorType". */
		return ErrorType;
	}

	/**
	 * @param errorType. Se asigna valor al atributo "errorType".
	 */
	public void setErrorType(ErrorType errorType) {
		/* Se asigna el valor del atributo "errorType" pasado por parametro. */
		ErrorType = errorType;
	}

	/**
	 * @return user. Se devuelve el atributo "user".
	 */
	
	public User getUser() {
		/* Se devuelve el valor del atributo "user". */
		return user;
	}

	/**
	 * @param user. Se asigna valor al atributo "user".
	 */
	public void setUser(User user) {
		/* Se asigna el valor del atributo "user" pasado por parametro. */
		this.user = user;
	}

	/**
	 * @return sessionId. Se devuelve el atributo "sessionId".
	 */
	
	public String getSessionId() {
		/* Se devuelve el valor del atributo "sessionId". */
		return sessionId;
	}

	/**
	 * @param sessionId. Se asigna valor al atributo "sessionId".
	 */
	public void setSessionId(String sessionId) {
		/* Se asigna el valor del atributo "sessionId" pasado por parametro. */
		this.sessionId = sessionId;
	}

	@Override
	/**
	 * @return String
	 * 
	 * <p> Metodo que devuelve la clase covertida a cadena de caracteres.</p>
	 * */
	public String toString() {				
		/* Se devuelve los atributos de la clase.*/
		return " Id " + this.id + " Fecha : " + Utils.parseDateString(this.date) + 
               " Nivel Traza : " + this.logLevel.getCode() +
		       " Módulo : " + this.appModule +
		       " Procedimiento : " + this.functionName +
		       " Texto : " + this.text +
		       " Tipo Error : " + this.ErrorType.getCode() +
		       " Usuario : " + this.user.getName() +
		       " Parámetros : " + this.parameters +
		       " Sesión : " + this.sessionId;
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
			if (obj instanceof Audit){
				/* Se compara los identificadores de la clase actual y 
				 * la 'Auditoria' recibida por parametro.*/
				resultado =  this.getId()== ((Audit) obj).getId();
			}
				
		}
		/* Se devuelve el resultado de la comparación.*/			
		return resultado;
	}

	/**
	 * @param Audit
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
	public int compareTo(Audit auditoria) {
		/* Se devuelve la comparación del nombre de la clase y 
		 * la 'Auditoria' recibida por parametro.*/
		return Utils.parseDateString(this.date).compareToIgnoreCase(Utils.parseDateString(auditoria.getDate()));
	}	
}
