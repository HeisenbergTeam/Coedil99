package servizi;

import java.util.List;

import modello_di_dominio.Commessa;
import modello_di_dominio.Ordine;

public interface GestoreOrdine extends Servizio{
	
	public Ordine creaOrdine();
	
	public void cancellaOrdine(int ID);
	
	public List<Ordine> getOrdini();
	
	public Ordine getOrdine(int ID);

	public void cancellaOrdine(Ordine ordine);
	
	public List<Commessa> getCommesseDaOrdine(Ordine ordine);
	
}
