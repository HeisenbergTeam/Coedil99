package servizi.impl;

import org.hibernate.classic.Session;

import servizi.Autenticazione;
import servizi.annotation.injected;
/**
 * AutenticazionePrototipo
 * @author mw
 *
 */
public class AutenticazionePrototipo implements Autenticazione {
	
	@injected(serviceImplementation = "SessionePrototipo")
	private Session session;
	
	public boolean login(String username, String password) {
		return true;
	}

}
