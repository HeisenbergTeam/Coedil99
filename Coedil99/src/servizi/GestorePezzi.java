package servizi;

import java.util.Date;
import java.util.List;

import modello_di_dominio.DescrizionePezzo;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;
import modello_di_dominio.Sagoma;

public interface GestorePezzi extends Servizio{
	
	public Pezzo creaPezzo();
	
	public Pezzo creaPezzo(DescrizionePezzo descPrezzo, Date dataArrivo, int quantita);
	
	public void cancellaPezzo(Pezzo pezzo);
	
	public void cancellaPezzoByID(int idPezzo);
	
	public List<Pezzo> getPezzi();
	
	public boolean verificaDisponibilita(int idPezzo, int quantita);

	public DescrizionePezzo creaDescrizionePezzo();
	
	public DescrizionePezzo creaDescrizionePezzo(String nome, float peso, float diametro, String fornitore);
	
	public Sagoma creaSagoma();
	
	public Sagoma creaSagoma(String pathImg);
	
	public LavorazionePezzo creaLavorazionePezzo();
	
	public LavorazionePezzo creaLavorazionePezzo(String descrizione, float misuraTaglio, float pesoPezzoLavorato, Sagoma sagoma);
	
}
