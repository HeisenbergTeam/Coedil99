package com.coedil99.servizi;
/**
 * 
 */
import com.coedil99.servizi.impl.GestoreServiziPrototipo;

/**
 * 
 * @author mw
 *
 */
public abstract class GestoreServizi {
/**
 * 
 */
	private static GestoreServizi _instance = new GestoreServiziPrototipo();
/**
 * getGestoreServizi
 * @return
 */
	public static GestoreServizi getGestoreServizi() {
		return _instance;
	}
/**
 * getServizio
 * @param classname
 * @return
 */
	public abstract Servizio getServizio(String classname);

}