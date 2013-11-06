package servizi;

import java.util.List;

import modello_di_dominio.Ordine;

public interface GestoreOrdine extends Servizio{
	
	public Ordine creaOrdine();
	
	public void cancellaOrdine(int ID);
	
	public List<Ordine> getOrdini();

	public void cancellaOrdine(Ordine ordine);
	
}
