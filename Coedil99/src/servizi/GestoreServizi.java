package servizi;

import servizi.impl.GestoreServiziPrototipo;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.DAOFactoryImpl;

public abstract class GestoreServizi {
	
	private static GestoreServizi _instance = new GestoreServiziPrototipo();
	
	public static GestoreServizi getGestoreServizi() {
		return _instance;
	}
	
	
	public abstract Servizio getServizio(String classname);
	
	

}