package com.coedil99.utilita;
/**
 * 
 */
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;

/**
 * 
 * @author mw
 *
 */
public abstract class UtilitaManager {
/**
 * 
 */
	private static UtilitaManager _instance = new UtilitaManagerPrototipo();
/**
 * getGestoreServizi
 * @return
 */
	public static UtilitaManager getGestoreServizi() {
		return _instance;
	}
/**
 * getServizio
 * @param classname
 * @return
 */
	public abstract Servizio getServizio(String classname);

}