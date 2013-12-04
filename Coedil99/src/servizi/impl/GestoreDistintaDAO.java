package servizi.impl;

import java.util.Date;
import java.util.List;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Distinta;
import modello_di_dominio.dao.DistintaDAO;

import org.orm.PersistentException;

import servizi.GestoreDistinta;
import edu.emory.mathcs.backport.java.util.Arrays;

public class GestoreDistintaDAO implements GestoreDistinta {

	private DistintaDAO distintaDAO;
	
	public GestoreDistintaDAO() {
		distintaDAO = DAOFactory.getDAOFactory().getDistintaDAO();
	}

	public Distinta creaDistinta() {
		return distintaDAO.createDistinta();
	}

	public Distinta creaDistinta(Date dataInizio, Commessa commessa,
			int revisione, String modello, String elementoStrutturale) {
		Distinta distinta = distintaDAO.createDistinta();
		distinta.setDataInizio(dataInizio);
		distinta.setCommessa(commessa);
		distinta.setRevisione(revisione);
		distinta.setModello(modello);
		distinta.setElementoStrutturale(elementoStrutturale);
		return distinta;
	}

	@SuppressWarnings("unchecked")
	public List<Distinta> getDistinte() {
		try {
			return Arrays.asList(distintaDAO.listDistintaByQuery(null, null));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Distinta getDistintaByID(int id) {
		try {
			return distintaDAO.getDistintaByORMID(id);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void cancellaDistinta(Distinta distinta) {
		try {
			distintaDAO.delete(distinta);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancellaDistintaByID(int id) {
		try {
			distintaDAO.delete(distintaDAO.getDistintaByORMID(id));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
