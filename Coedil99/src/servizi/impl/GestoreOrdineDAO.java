package servizi.impl;

import java.util.List;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Ordine;
import modello_di_dominio.dao.OrdineDAO;

import org.orm.PersistentException;

import servizi.GestoreOrdine;
import edu.emory.mathcs.backport.java.util.Arrays;

public class GestoreOrdineDAO implements GestoreOrdine {

	private OrdineDAO ordineDAO;

	public GestoreOrdineDAO() {

		ordineDAO = DAOFactory.getDAOFactory().getOrdineDAO();

	}

	@Override
	public Ordine creaOrdine() {

		return ordineDAO.createOrdine();
	}

	@Override
	public void cancellaOrdine(Ordine ordine) {

		try {
			ordineDAO.delete(ordine);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> getOrdini() {
		try {
			return Arrays.asList(ordineDAO.listOrdineByQuery(null, null));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Ordine getOrdine(int ID) {
		try {
			return ordineDAO.getOrdineByORMID(ID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void cancellaOrdine(int ID) {
		try {
			ordineDAO.delete(ordineDAO.getOrdineByORMID(ID));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Commessa> getCommesseDaOrdine(Ordine ordine) {
		try {
			return Arrays
					.asList(ordineDAO.getOrdineByORMID(ordine.getID()).commesse
							.toArray());
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
