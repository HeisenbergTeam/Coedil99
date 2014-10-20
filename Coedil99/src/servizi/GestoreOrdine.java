package servizi;

import java.util.Date;
import java.util.List;

import modello_di_dominio.Destinazione;

import modello_di_dominio.Commessa;

import modello_di_dominio.Ordine;

public interface GestoreOrdine extends Servizio {
	
	public Ordine creaOrdine();
	
	public Ordine creaOrdine(Destinazione destinazione, Date dataConsegna);

	public List<Ordine> getOrdini();
	
	public Ordine getOrdine(int IdOrdine);

	public void cancellaOrdineByID(int IdOrdine);
	
	public void cancellaOrdine(Ordine ordine);
	
	public List<Commessa> getCommesseDaOrdineByID(int IdOrdine);

	public List<Commessa> getCommesseDaOrdine(Ordine ordine);
	
	public Commessa creaCommessaByID(int IdOrdine);
	
	public Commessa creaCommessa(Ordine ordine);
	
	public Commessa creaCommessaByID(int IdOrdine, int priorita, Date dataCommessa);
	
	public Commessa creaCommessa(Ordine ordine, int priorita, Date dataCommessa);
	
	public Destinazione creaDestinazione();
	
	public Destinazione creaDestinazione(String via);
	
	public void modificaDestinazione(Ordine ordine, String via);

	public void modificaDestinazioneByOrderID(int idOrdine, String via);
	
}