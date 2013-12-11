package servizi;

import modello_di_dominio.Commessa;
import modello_di_dominio.Distinta;

public interface GestoreCommessa extends Servizio {

	public void cancellaCommessa(Commessa commessa);

	public void cancellaCommessaDaID(int id);
	
	public Distinta creaDistinta(Commessa commessa);

	public Distinta getDistintaDaCommessa(Commessa commessa);

}
