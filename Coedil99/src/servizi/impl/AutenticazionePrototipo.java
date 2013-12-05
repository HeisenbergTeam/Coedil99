package servizi.impl;

import servizi.Autenticazione;
import servizi.GestoreServizi;
import servizi.Log;
import servizi.annotation.injected;
import servizi.Sessione;
/**
 * AutenticazionePrototipo
 * @author mw
 *
 */
public class AutenticazionePrototipo implements Autenticazione {
	/**
	 * 
	 */
	protected Sessione session;
	/**
	 * 
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
