package servizi;

import java.util.List;

import modello_di_dominio.Commessa;

public interface GestoreCommessa {

	public Commessa creaCommessa();

	public void cancellaCommessa(Commessa commessa);

	public void cancellaCommessaDaID(int id);

	public List<Commessa> getCommesse();

}
