package servizi.impl;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Distinta;
import modello_di_dominio.dao.CommessaDAO;

import org.orm.PersistentException;

import servizi.GestoreCommessa;

/**
 * GestoreCommessaDAO
 * 
 * @author mw
 * 
 */
public class GestoreCommessaDAO implements GestoreCommessa {
	/**
	 * CommessaDAO
	 */
	private CommessaDAO commessaDAO;

	/**
	 * Costruttore
	 */
	public GestoreCommessaDAO() {
		commessaDAO = DAOFactory.getDAOFactory().getCommessaDAO();
	}

	@Override
	public void cancellaCommessa(Commessa commessa) {
		try {
			commessaDAO.deleteAndDissociate(commessa);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void cancellaCommessaDaID(int id) {
		try {
			commessaDAO.deleteAndDissociate(commessaDAO.getCommessaByORMID(id));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Distinta creaDistinta(Commessa commessa) {
		Distinta distinta = commessa.creaDistinta();
		try {
			DAOFactory.getDAOFactory().getDistintaDAO().save(distinta);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return distinta;
	}

	@Override
	public Distinta getDistintaDaCommessa(Commessa commessa) {
		try {
			return commessaDAO.getCommessaByORMID(commessa.getID())
					.getDistinta();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
