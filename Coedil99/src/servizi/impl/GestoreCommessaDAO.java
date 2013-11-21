package servizi.impl;

import java.util.List;

import org.orm.PersistentException;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.dao.CommessaDAO;
import servizi.GestoreCommessa;
import edu.emory.mathcs.backport.java.util.Arrays;

public class GestoreCommessaDAO implements GestoreCommessa {

	private CommessaDAO commessaDAO;

	public GestoreCommessaDAO() {
		commessaDAO = DAOFactory.getDAOFactory().getCommessaDAO();
	}

	public Commessa creaCommessa() {
		return commessaDAO.createCommessa();
	}
	
	public void cancellaCommessa(Commessa commessa) {
		try {
			commessaDAO.delete(commessa);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancellaCommessaDaID(int id) {
		try {
			commessaDAO.delete(commessaDAO.getCommessaByORMID(id));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Commessa> getCommesse() {
		try {
			return Arrays.asList(commessaDAO.listCommessaByQuery(null, null));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
