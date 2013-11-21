package servizi;

import java.util.List;

import modello_di_dominio.Commessa;
import modello_di_dominio.Distinta;

public interface GestoreCommessa {

	public Commessa creaCommessa();

	public void cancellaCommessa(Commessa commessa);

	public void cancellaCommessaDaID(int id);

	public List<Commessa> getCommesse();

	public Distinta getDistintaDaCommessa(Commessa commessa);

}
