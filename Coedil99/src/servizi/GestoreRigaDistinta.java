package servizi;

import java.util.List;

import modello_di_dominio.Distinta;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;
import modello_di_dominio.Sagoma;

public interface GestoreRigaDistinta extends Servizio {

	public RigaDistinta creaRigaDistinta(Pezzo pezzo, Distinta distinta,
			LavorazionePezzo lavorazione, String indicazione);

	public RigaDistinta modificaRigaDistintaBYID(int id, Pezzo pezzo,
			Distinta distinta, LavorazionePezzo lavorazione, String indicazione);
	
	public List<RigaDistinta> getRigheDistinta();

	public RigaDistinta getRigaDistintaByID(int id);

	public void cancellaRigaDistinta(RigaDistinta riga);

	public void cancellaRigaDistintaByID(int id);

	public LavorazionePezzo creaLavorazionePezzo();
	
	public LavorazionePezzo creaLavorazionePezzo(String descrizione, float misuraTaglio, float pesoPezzoLavorato, Sagoma sagoma);
	
	public Sagoma creaSagoma();
	
	public Sagoma creaSagoma(String pathImg);
	
	public LavorazionePezzo modificaLavorazionePezzoByRigaDistintaID(int id, String descrizione, float misuraTaglio, float pesoPezzoLavorato, Sagoma sagoma);
	
	public LavorazionePezzo modificaLavorazionePezzoByRigaDistinta(RigaDistinta rigaDistinta, String descrizione, float misuraTaglio, float pesoPezzoLavorato, Sagoma sagoma);

    public void cancellaLavorazionePezzoByRigaDistintaID(int id);

    public void cancellaLavorazionePezzoByRigaDistinta(RigaDistinta rigaDistinta);

    public Sagoma modificaSagomaByRigaDistintaID(int id, String pathImg);
	
	public Sagoma modificaSagomaByRigaDistinta(RigaDistinta rigaDistinta, String pathImg);

    public void cancellaSagomaByRigaDistintaID(int id);

    public void cancellaSagomaByRigaDistinta(RigaDistinta rigaDistinta);
	
}
