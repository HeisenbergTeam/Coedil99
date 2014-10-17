package servizi.impl;

import java.util.List;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Distinta;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;
import modello_di_dominio.dao.RigaDistintaDAO;

import org.orm.PersistentException;

import servizi.GestoreRigaDistinta;
import edu.emory.mathcs.backport.java.util.Arrays;

public class GestoreRigaDistintaDAO implements GestoreRigaDistinta {

	private RigaDistintaDAO rigaDistintaDAO;

	public GestoreRigaDistintaDAO() {
		rigaDistintaDAO = DAOFactory.getDAOFactory().getRigaDistintaDAO();
	}

	public RigaDistinta creaRigaDistinta(Pezzo pezzo, Distinta distinta,
			LavorazionePezzo lavorazione, String indicazione) {
		RigaDistinta riga = rigaDistintaDAO.createRigaDistinta();
		riga.setDistinta(distinta);
		riga.setLavorazionePezzo(lavorazione);
		riga.setIndicazione(indicazione);		
		riga.setPezzo(pezzo);
		
		distinta.righeDistinta.add(riga);
		
		try {
			rigaDistintaDAO.save(riga);
			DAOFactory.getDAOFactory().getDistintaDAO().save(distinta);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return riga;
	}

	public void modificaRigaDistintaBYID(int id, Pezzo pezzo,
			Distinta distinta, LavorazionePezzo lavorazione, String indicazione) {
		RigaDistinta riga;
		try {
			riga = rigaDistintaDAO.getRigaDistintaByORMID(id);
			riga.setDistinta(distinta);
			riga.setLavorazionePezzo(lavorazione);
			riga.setIndicazione(indicazione);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<RigaDistinta> getRigheDistinta() {
		try {
			return Arrays.asList(rigaDistintaDAO.listRigaDistintaByQuery(null, null));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public RigaDistinta getRigaDistintaByID(int id) {
		try {
			return rigaDistintaDAO.getRigaDistintaByORMID(id);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void cancellaRigaDistinta(RigaDistinta riga) {
		try {
			rigaDistintaDAO.deleteAndDissociate(riga);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancellaRigaDistintaByID(int id) {
		try {
			rigaDistintaDAO.deleteAndDissociate(rigaDistintaDAO.getRigaDistintaByORMID(id));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
