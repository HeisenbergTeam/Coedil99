package servizi;

import java.util.Date;
import java.util.List;

import modello_di_dominio.Commessa;
import modello_di_dominio.Distinta;

public interface GestoreDistinta extends Servizio {

	public Distinta creaDistinta();

	public Distinta creaDistinta(Date dataInizio, Commessa commessa,
			int revisione, String modello, String elementoStrutturale);
	
	public List<Distinta> getDistinte();
	
	public Distinta getDistintaByID(int id);
	
	public void cancellaDistinta(Distinta distinta);
	
	public void cancellaDistintaByID(int id);

}
