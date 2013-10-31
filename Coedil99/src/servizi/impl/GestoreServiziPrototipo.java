package servizi.impl;

import java.util.HashMap;

import servizi.Servizio;

public class GestoreServiziPrototipo {

	private static GestoreServiziPrototipo _instance = new GestoreServiziPrototipo();

	private HashMap<String, Servizio> Servizi;

	public static GestoreServiziPrototipo getGestoreServiziPrototipo() {
		return _instance;
	}

	public HashMap<String, Servizio> getServizi() {
		return this.Servizi;
	}

	public Servizio getServizioDaNome(String nome) {
		return this.Servizi.get(nome);
	}

}
