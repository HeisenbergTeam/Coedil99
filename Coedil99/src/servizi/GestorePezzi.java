package servizi;

import java.util.List;

import modello_di_dominio.Pezzo;

public interface GestorePezzi {
	
	public Pezzo creaPezzo();
	
	public void cancellaPezzo(Pezzo pezzo);
	
	public void cancellaPezzoDaID(int id);
	
	public List<Pezzo> getPezzi();
	
	public boolean verificaDisponibilita(int id, int quantita);

}
