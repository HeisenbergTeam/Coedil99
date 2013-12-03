package servizi.impl;

import java.util.List;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Distinta;
import modello_di_dominio.dao.CommessaDAO;

import org.orm.PersistentException;

import servizi.GestoreCommessa;
import edu.emory.mathcs.backport.java.util.Arrays;

public class GestoreCommessaDAO implements GestoreCommessa {

	private CommessaDAO commessaDAO;

	public GestoreCommessaDAO() {
		commessaDAO = DAOFactory.getDAOFactory().getCommessaDAO();
	}

	@Override
	public void cancellaCommessa(Commessa commessa) {
		try {
			commessaDAO.delete(commessa);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void cancellaCommessaDaID(int id) {
		try {
			commessaDAO.delete(commessaDAO.getCommessaByORMID(id));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
