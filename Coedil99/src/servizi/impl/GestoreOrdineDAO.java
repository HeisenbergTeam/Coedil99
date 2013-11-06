package servizi.impl;

import org.orm.PersistentException;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.Ordine;
import modello_di_dominio.dao.OrdineDAO;
import servizi.GestoreOrdine;

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

	@Override
	public Ordine[] getOrdini() {
		try {
			ordineDAO.listOrdineByQuery(null, null);
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

}
