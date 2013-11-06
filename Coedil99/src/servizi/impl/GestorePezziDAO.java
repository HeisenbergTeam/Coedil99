package servizi.impl;

import java.util.Arrays;
import java.util.List;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Pezzo;
import modello_di_dominio.dao.PezzoDAO;

import org.orm.PersistentException;

import servizi.GestorePezzi;

public class GestorePezziDAO implements GestorePezzi {
	
	private PezzoDAO pezzoDAO;
	
	public GestorePezziDAO() {
		pezzoDAO = DAOFactory.getDAOFactory().getPezzoDAO();
	}

	public Pezzo creaPezzo() {
		return pezzoDAO.createPezzo();
	}

	public void cancellaPezzo(Pezzo pezzo) {
		try {
			pezzoDAO.delete(pezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancellaPezzoDaID(int id) {
		try {
			pezzoDAO.delete(pezzoDAO.getPezzoByORMID(id));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Pezzo> getPezzi() {
		try {
			return Arrays.asList(pezzoDAO.listPezzoByQuery(null, null));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean verificaDisponibilita(int id, int quantita) {
		try {
			return pezzoDAO.getPezzoByORMID(id).getQuantita() >= quantita;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
