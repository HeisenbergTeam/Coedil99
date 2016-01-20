package com.coedil99.utilita;
/**
 * 
 * @author mw
 *
 */
public interface Config extends Servizio {
	/**
	 * 
	 * @param name
	 * @return
	 */
	public String get(String name);
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void set(String name,String value);
	/**
	 * 
	 * @param name
	 */
	public void delete(String name);
}
