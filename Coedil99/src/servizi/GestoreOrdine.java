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

	public void setDestinazioneOrdineByID(int IdOrdine, Destinazione destinazione);
	
	public void setDestinazioneOrdine(Ordine ordine, Destinazione destinazione);
	
	public void setDataConsegnaOrdineByID(int IdOrdine, Date dataConsegna);
	
	public void setDataConsegnaOrdine(Ordine ordine, Date dataConsegna);

	public List<Commessa> getCommesseDaOrdine(Ordine ordine);

}