package modello_di_dominio;

public class GestoreOrdini {
	
	public static GestoreOrdini _instance = new GestoreOrdini();
	
	public static GestoreOrdini getInstance() {
		return _instance;
	}
	
	public void creaOrdine() {
		servizi.Sessione.getInstance().setOrdineAttuale(new Ordine());
	}

}
