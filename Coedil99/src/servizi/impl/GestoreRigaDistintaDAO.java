package servizi.impl;

import java.util.List;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Distinta;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;
import modello_di_dominio.Sagoma;
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

	public RigaDistinta modificaRigaDistintaBYID(int id, Pezzo pezzo,
			Distinta distinta, LavorazionePezzo lavorazione, String indicazione) {
		RigaDistinta riga = null;
		try {
			riga = rigaDistintaDAO.getRigaDistintaByORMID(id);
			riga.setDistinta(distinta);
			riga.setLavorazionePezzo(lavorazione);
			riga.setIndicazione(indicazione);
			rigaDistintaDAO.save(riga);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return riga;
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
	@Override
	public Sagoma creaSagoma() {
		Sagoma sagoma = DAOFactory.getDAOFactory().getSagomaDAO().createSagoma();
		try {
			DAOFactory.getDAOFactory().getSagomaDAO().save(sagoma);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sagoma;
	}
	@Override
	public Sagoma creaSagoma(String pathImg) {
		Sagoma sagoma = DAOFactory.getDAOFactory().getSagomaDAO().createSagoma();
		sagoma.setImg(pathImg);
		try {
			DAOFactory.getDAOFactory().getSagomaDAO().save(sagoma);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sagoma;
	}
	@Override
	public LavorazionePezzo creaLavorazionePezzo() {
		LavorazionePezzo lavorazionePezzo = DAOFactory.getDAOFactory().getLavorazionePezzoDAO().createLavorazionePezzo();
		try {
			DAOFactory.getDAOFactory().getLavorazionePezzoDAO().save(lavorazionePezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lavorazionePezzo;
	}
	@Override
	public LavorazionePezzo creaLavorazionePezzo(String descrizione,
			float misuraTaglio, float pesoPezzoLavorato, Sagoma sagoma) {
		LavorazionePezzo lavorazionePezzo = DAOFactory.getDAOFactory().getLavorazionePezzoDAO().createLavorazionePezzo();
		lavorazionePezzo.setDescrizione(descrizione);
		lavorazionePezzo.setMisuraDiTaglio(misuraTaglio);
		lavorazionePezzo.setPeso(pesoPezzoLavorato);
		lavorazionePezzo.setSagoma(sagoma);
		try {
			DAOFactory.getDAOFactory().getLavorazionePezzoDAO().save(lavorazionePezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lavorazionePezzo;
	}

	@Override
	public LavorazionePezzo modificaLavorazionePezzoByRigaDistintaID(int id,
			String descrizione, float misuraTaglio, float pesoPezzoLavorato,
			Sagoma sagoma) {
		RigaDistinta rigaDistinta = null;
		try {
			rigaDistinta = rigaDistintaDAO.getRigaDistintaByORMID(id);
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return modificaLavorazionePezzoByRigaDistinta(rigaDistinta, descrizione, misuraTaglio, pesoPezzoLavorato, sagoma);
	}

	@Override
	public LavorazionePezzo modificaLavorazionePezzoByRigaDistinta(
			RigaDistinta rigaDistinta, String descrizione, float misuraTaglio,
			float pesoPezzoLavorato, Sagoma sagoma) {
		LavorazionePezzo lavorazionePezzo = null;
		try {
			lavorazionePezzo = rigaDistinta.getLavorazionePezzo();
			lavorazionePezzo.setDescrizione(descrizione);
			lavorazionePezzo.setMisuraDiTaglio(misuraTaglio);
			lavorazionePezzo.setPeso(pesoPezzoLavorato);
			lavorazionePezzo.setSagoma(sagoma);
			DAOFactory.getDAOFactory().getLavorazionePezzoDAO().save(lavorazionePezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lavorazionePezzo;
	}

	@Override
	public Sagoma modificaSagomaByRigaDistintaID(int id, String pathImg) {
		RigaDistinta rigaDistinta = null;
		try {
			rigaDistinta = rigaDistintaDAO.getRigaDistintaByORMID(id);
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return modificaSagomaByRigaDistinta(rigaDistinta, pathImg);
	}

	@Override
	public Sagoma modificaSagomaByRigaDistinta(RigaDistinta rigaDistinta,
			String pathImg) {
		Sagoma sagoma = null;
		try {
			sagoma = rigaDistinta.getLavorazionePezzo().getSagoma();
			sagoma.setImg(pathImg);
			DAOFactory.getDAOFactory().getSagomaDAO().save(sagoma);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sagoma;
	}

}
