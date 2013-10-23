package modello_di_dominio;

public class GestorePezzi {
	
	public static GestorePezzi _instance = new GestorePezzi();
	
	public static GestorePezzi getInstance() {
		return _instance;
	}
	
	public void creaPezzo() {
		
	}
	
	public boolean verificaDisponibilita() {
		return true;
	}

}
