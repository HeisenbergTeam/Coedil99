package com.coedil99.utilita.impl;

import com.coedil99.utilita.Autenticazione;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Sessione;
/**
 * AutenticazionePrototipo
 * @author mw
 *
 */
public class AutenticazionePrototipo implements Autenticazione {
	/**
	 * Session service
	 */
	protected Sessione session;
	/**
	 * Log service
	 */
	protected Log log;
	/**
	 * Costruttore
	 */
	public AutenticazionePrototipo(){
		log = (Log) UtilitaManager.getGestoreServizi().getServizio("LogStdout");
		session = (Sessione) UtilitaManager.getGestoreServizi().getServizio("SessionePrototipo");
	}
	/**
	 * 
	 */
	public boolean login(String username, String password) {
		
		log.i("Username loggato: " + username);
        log.i("Password loggato: " + password);
        if(!username.equals("admin"))
            return false;

        if(!password.equals("admin"))
            return false;


		
		return true;
	}

}
