package com.coedil99.utilita;

public interface Log extends Servizio {
/**
 * debug method
 * @param message
 */
	public void d(String message);
/**
 * error method
 * @param message
 */
	public void e(String message);
/**
 * info method
 * @param message
 */
	public void i(String message);
/**
 * warning method
 * @param message
 */
	public void w(String message);
	
}
