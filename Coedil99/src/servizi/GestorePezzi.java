package servizi;

import java.util.List;

import modello_di_dominio.Pezzo;

public interface GestorePezzi extends Servizio{
	
	public Pezzo creaPezzo();
	
	public void cancellaPezzo(Pezzo pezzo);
	
	public void cancellaPezzoByID(int idPezzo);
	
	public List<Pezzo> getPezzi();
	
	public boolean verificaDisponibilita(int idPezzo, int quantita);

}
