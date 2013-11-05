package servizi.impl;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

import servizi.GestoreServizi;
import servizi.Servizio;

public class GestoreServiziPrototipo implements GestoreServizi {

	private static GestoreServiziPrototipo _instance = new GestoreServiziPrototipo();

	private HashMap<String, Servizio> Servizi;
	
	public GestoreServiziPrototipo(){
		
	}
	
	public static GestoreServiziPrototipo getGestoreServiziPrototipo() {
		return _instance;
	}

	public HashMap<String, Servizio> getServizi() {
		return this.Servizi;
	}

	public Servizio getServizioDaNome(String nome) {
		return this.Servizi.get(nome);
	}

	@Override
	public Servizio getServizio(String classname) {
		Class c;
		try {
			c = Class.forName("servizi."+classname);
			//ClassLoader cl = new URLClassLoader(URL[]{new URL(".")});
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
