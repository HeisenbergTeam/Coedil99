package servizi;

import modello_di_dominio.Ordine;

public interface GestoreOrdine extends Servizio{
	
	public Ordine creaOrdine();
	
	public void cancellaOrdine(int ID);
	
	public Ordine[] getOrdini();

	public void cancellaOrdine(Ordine ordine);
	
}
