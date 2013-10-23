package servizi;

import modello_di_dominio.Commessa;
import modello_di_dominio.Distinta;
import modello_di_dominio.Ordine;

public class Sessione {
	
	public static Sessione _instance = new Sessione();

	public Ordine ordineAttuale;

	public Commessa commessaAttuale;
	
	public Distinta ditintaAttuale;
	
	public static Sessione getInstance() {
		return _instance;
	}
	
	public Ordine getOrdineAttuale() {
		return ordineAttuale;
	}

	public void setOrdineAttuale(Ordine ordineAttuale) {
		this.ordineAttuale = ordineAttuale;
	}

	public Commessa getCommessaAttuale() {
		return commessaAttuale;
	}

	public void setCommessaAttuale(Commessa commessaAttuale) {
		this.commessaAttuale = commessaAttuale;
	}

	public Distinta getDitintaAttuale() {
		return ditintaAttuale;
	}

	public void setDitintaAttuale(Distinta ditintaAttuale) {
		this.ditintaAttuale = ditintaAttuale;
	}
	
}
