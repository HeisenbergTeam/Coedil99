package servizi.impl;

import org.hibernate.classic.Session;

import servizi.Autenticazione;
import servizi.GestoreServizi;
import servizi.Log;
import servizi.annotation.injected;
/**
 * AutenticazionePrototipo
 * @author mw
 *
 */
public class AutenticazionePrototipo implements Autenticazione {
	
	protected Session session;
	
	protected Log log;
	
	public AutenticazionePrototipo(){
		log = (Log) GestoreServizi.getGestoreServizi().getServizio("LogStdout");
		session = (Session) GestoreServizi.getGestoreServizi().getServizio("session");
	}
	
	public boolean login(String username, String password) {
		
		log.i("Username loggato" + username);
		
		return true;
	}

}
