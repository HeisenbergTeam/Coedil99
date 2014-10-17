package servizi.impl;

import java.util.Date;
import java.util.List;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Destinazione;
import modello_di_dominio.LavorazionePezzo;
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
		Ordine ordine = ordineDAO.createOrdine();
		try {
			ordineDAO.save(ordine);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordine;
	}

	@Override
	public Ordine creaOrdine(Destinazione destinazione, Date dataConsegna) {
		Ordine ordine = ordineDAO.createOrdine();
		ordine.setDataCreazione(dataConsegna);
		ordine.setDestinazione(destinazione);
		try {
			ordineDAO.save(ordine);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordine;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> getOrdini() {
		try {
			return Arrays.asList(ordineDAO.listOrdineByQuery(null, null));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Ordine getOrdine(int IdOrdine) {
		try {
			return ordineDAO.getOrdineByORMID(IdOrdine);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void cancellaOrdine(Ordine ordine) {

		try {
			ordineDAO.deleteAndDissociate(ordine);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancellaOrdineByID(int IdOrdine) {
		try {
			cancellaOrdine(ordineDAO.getOrdineByORMID(IdOrdine));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commessa> getCommesseDaOrdine(Ordine ordine) {
		try {
			return Arrays
					.asList(ordineDAO.getOrdineByORMID(ordine.getID()).commesse
							.toArray());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Commessa> getCommesseDaOrdineByID(int IdOrdine) {
		try {
			getCommesseDaOrdine(ordineDAO.getOrdineByORMID(IdOrdine));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Commessa creaCommessa(Ordine ordine) {
		//Commessa commessa = ordine.creaCommessa();
		Commessa commessa = DAOFactory.getDAOFactory().getCommessaDAO().createCommessa();
		try {
			DAOFactory.getDAOFactory().getCommessaDAO().save(commessa);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commessa;
	}

	@Override
	public Commessa creaCommessaByID(int IdOrdine) {
		try {
			return ordineDAO.getOrdineByORMID(IdOrdine).creaCommessa();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Commessa creaCommessa(Ordine ordine, int priorita, Date dataCommessa) {
		//Commessa commessa = ordine.creaCommessa();
		Commessa commessa = DAOFactory.getDAOFactory().getCommessaDAO().createCommessa();
		commessa.setPriorita(priorita);
		commessa.setDataCreazione(dataCommessa);
		commessa.setOrdine(ordine);
		try {
			DAOFactory.getDAOFactory().getCommessaDAO().save(commessa);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commessa;
	}

	@Override
	public Commessa creaCommessaByID(int IdOrdine, int priorita,
			Date dataCommessa) {
		try {
			creaCommessa(ordineDAO.getOrdineByORMID(IdOrdine), priorita,
					dataCommessa);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Destinazione creaDestinazione() {
		Destinazione destinazione = DAOFactory.getDAOFactory().getDestinazioneDAO().createDestinazione();
		try {
			DAOFactory.getDAOFactory().getDestinazioneDAO().save(destinazione);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinazione;
	}

	@Override
	public Destinazione creaDestinazione(String via) {
		Destinazione destinazione = DAOFactory.getDAOFactory().getDestinazioneDAO().createDestinazione();
		destinazione.setVia(via);
		try {
			DAOFactory.getDAOFactory().getDestinazioneDAO().save(destinazione);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinazione;
	}

}
