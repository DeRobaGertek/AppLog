package com.gertek.multilinefreeflow.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Raúl De Roba 18 de abr. de 2017
 * 
 * <p> clase que contiene diferentes metodos que pueden ser de utilidad en
 *     diferentes paquetes a la hora de castear clases o tratamiento expecificos. </p>
 *
 */
public final class Utils {
	
	/* Se declara el conenedor de los LOG4J.*/
	static Logger utilLogger = LoggerFactory.getLogger(Utils.class);

	public Utils() {
	}
	
	/** 
	 * @param date Parametro fecha a convertir en una cadena de caracteres.
	 * @return String Cadena de caracteres devuelta en función de una fecha.
	 * 
	 * <p> Metodo que recibe una fecha y devuelve una cadena de caracteres. </p>
	 * 
	 */
	public static String parseDateString(Date date){
		/* Se declara una variable String para devolver el resultado del casteo. */
		String resultado = "";
		
		/* Se comrpueba que se haya recibido una fecha.*/
		if (null != date){
			/* Se declara e instancia la clase gregoriana para trabajar con la fecha.*/
			GregorianCalendar calendar = null;
			
			/* Se crea una estructura para capturar excepciones.*/
			try{
				/* Se asigna la fecha de la clase al calendario gregoriaono.*/
				calendar.setTime(date);	
				/* Se monta la fecha en una variable String 
				   (Enero lo interpreta como mes 0,por lo que se ha de sumar 1).*/
				resultado = calendar.get(Calendar.DAY_OF_MONTH) + "/" + 
				           (calendar.get(Calendar.MONTH) + 1) + "/" + 
				            calendar.get(Calendar.YEAR);
			} catch (Exception e){
				/* Se traza la inserción del dato academico. */
				utilLogger.error("Fecha Incorrecta." + e.getStackTrace());				
			}
		}
		/* Se devuelve el resultado del casteo. */
		return resultado;		
	}
}
