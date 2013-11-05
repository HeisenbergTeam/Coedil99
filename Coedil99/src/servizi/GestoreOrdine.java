package servizi;

import modello_di_dominio.Ordine;

public interface GestoreOrdine extends Servizio{
	
	public Ordine creaOrdine();
	
	public Ordine cancellaOrdine(int ID);
	
	public Ordine[] getOrdini();

	public void cancellaOrdine(Ordine ordine);
	
}
