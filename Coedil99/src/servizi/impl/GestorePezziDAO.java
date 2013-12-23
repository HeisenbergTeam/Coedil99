package servizi.impl;

import java.util.Arrays;
import java.util.List;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Pezzo;
import modello_di_dominio.dao.PezzoDAO;

import org.orm.PersistentException;

import servizi.GestorePezzi;

public class GestorePezziDAO implements GestorePezzi {
/**
 * 
 */
	private PezzoDAO pezzoDAO;
/**
 * 
 */
	public GestorePezziDAO() {
		pezzoDAO = DAOFactory.getDAOFactory().getPezzoDAO();
	}
/**
 * 
 */
	public Pezzo creaPezzo() {
		return pezzoDAO.createPezzo();
	}
/**
 * 
 */
	public void cancellaPezzo(Pezzo pezzo) {
		try {
			pezzoDAO.delete(pezzo);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void cancellaPezzoByID(int idPezzo) {
		try {
			cancellaPezzo(pezzoDAO.getPezzoByORMID(idPezzo));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public List<Pezzo> getPezzi() {
		try {
			return Arrays.asList(pezzoDAO.listPezzoByQuery(null, null));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean verificaDisponibilita(int idPezzo, int quantita) {
		try {
			return pezzoDAO.getPezzoByORMID(idPezzo).getQuantita() >= quantita;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

}
