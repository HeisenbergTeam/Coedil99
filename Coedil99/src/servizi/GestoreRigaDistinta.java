package servizi;

import java.util.List;

import modello_di_dominio.Distinta;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;

public interface GestoreRigaDistinta extends Servizio {

	public RigaDistinta creaRigaDistinta(Pezzo pezzo, Distinta distinta,
			LavorazionePezzo lavorazione, String indicazione);

	public void modificaRigaDistintaBYID(int id, Pezzo pezzo,
			Distinta distinta, LavorazionePezzo lavorazione, String indicazione);
	
	public List<RigaDistinta> getRigheDistinta();

	public RigaDistinta getRigaDistintaByID(int id);

	public void cancellaRigaDistinta(RigaDistinta riga);

	public void cancellaRigaDistintaByID(int id);

}
