package com.coedil99.servizi.impl;

import com.coedil99.servizi.Autenticazione;
import com.coedil99.servizi.GestoreServizi;
import com.coedil99.servizi.Log;
import com.coedil99.servizi.Sessione;
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
		log = (Log) GestoreServizi.getGestoreServizi().getServizio("LogStdout");
		session = (Sessione) GestoreServizi.getGestoreServizi().getServizio("SessionePrototipo");
	}
	/**
	 * 
	 */
	public boolean login(String username, String password) {
		
		log.i("Username loggato" + username);
		
		return true;
	}

}
