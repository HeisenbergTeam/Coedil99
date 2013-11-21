package servizi.impl;

import java.util.Date;
import java.util.List;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Destinazione;
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
	public Ordine creaOrdine(Destinazione destinazione, Date dataConsegna) {
		Ordine ordine = ordineDAO.createOrdine();
		ordine.setDataCreazione(dataConsegna);
		ordine.setDestinazione(destinazione);
		return ordine;
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
	public Ordine getOrdine(int IdOrdine) {
		try {
			return ordineDAO.getOrdineByORMID(IdOrdine);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void cancellaOrdine(Ordine ordine) {

		try {
			ordineDAO.deleteAndDissociate(ordine);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void cancellaOrdineByID(int IdOrdine) {
		try {
			cancellaOrdine(ordineDAO.getOrdineByORMID(IdOrdine));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setDestinazioneOrdine(Ordine ordine, Destinazione destinazione) {
		ordine.setDestinazione(destinazione);
	}

	@Override
	public void setDataConsegnaOrdine(Ordine ordine, Date dataConsegna) {
		ordine.setDataCreazione(dataConsegna);
	}

	@Override
	public void setDestinazioneOrdineByID(int IdOrdine, Destinazione destinazione) {
		try {
			setDestinazioneOrdine(ordineDAO.getOrdineByORMID(IdOrdine),destinazione);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setDataConsegnaOrdineByID(int IdOrdine, Date dataConsegna) {
		try {
			setDataConsegnaOrdine(ordineDAO.getOrdineByORMID(IdOrdine),dataConsegna);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
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
