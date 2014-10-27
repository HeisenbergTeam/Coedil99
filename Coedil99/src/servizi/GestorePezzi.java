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

    public Pezzo modificaPezzoByID(int idPezzo, DescrizionePezzo descPrezzo, Date dataArrivo, int quantita);

    public Pezzo modificaPezzo(Pezzo pezzo, DescrizionePezzo descPrezzo, Date dataArrivo, int quantita);

    public DescrizionePezzo modificaDescrizionePezzo(DescrizionePezzo descrizionePezzo, String nome, float peso, float diametro, String fornitore);

    public DescrizionePezzo modificaDescrizionePezzobyID(int idDescrizionePezzo, String nome, float peso, float diametro, String fornitore);

}
