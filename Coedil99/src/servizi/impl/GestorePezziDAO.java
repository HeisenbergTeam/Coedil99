package servizi.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import modello_di_dominio.DAOFactory;
import modello_di_dominio.DescrizionePezzo;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;
import modello_di_dominio.Sagoma;
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
		Pezzo pezzo = pezzoDAO.createPezzo();
		try {
			pezzoDAO.save(pezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pezzo;
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
	@Override
	public Pezzo creaPezzo(DescrizionePezzo descPrezzo, Date dataArrivo,
			int quantita) {
		Pezzo pezzo = pezzoDAO.createPezzo();
		pezzo.setDataArrivo(dataArrivo);
		pezzo.setDescrizionePezzo(descPrezzo);
		pezzo.setQuantita(quantita);
		try {
			pezzoDAO.save(pezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pezzo;
	}
	@Override
	public DescrizionePezzo creaDescrizionePezzo() {
		DescrizionePezzo descrizionePezzo = DAOFactory.getDAOFactory().getDescrizionePezzoDAO().createDescrizionePezzo();
		try {
			DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(descrizionePezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return descrizionePezzo;
	}
	@Override
	public DescrizionePezzo creaDescrizionePezzo(String nome, float peso,
			float diametro, String fornitore) {
		DescrizionePezzo descrizionePezzo = DAOFactory.getDAOFactory().getDescrizionePezzoDAO().createDescrizionePezzo();
		descrizionePezzo.setDiametro(diametro);
		descrizionePezzo.setFornitore(fornitore);
		descrizionePezzo.setNome(nome);
		descrizionePezzo.setPeso(peso);
		try {
			DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(descrizionePezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return descrizionePezzo;
	}
	@Override
	public Sagoma creaSagoma() {
		Sagoma sagoma = DAOFactory.getDAOFactory().getSagomaDAO().createSagoma();
		try {
			DAOFactory.getDAOFactory().getSagomaDAO().save(sagoma);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sagoma;
	}
	@Override
	public Sagoma creaSagoma(String pathImg) {
		Sagoma sagoma = DAOFactory.getDAOFactory().getSagomaDAO().createSagoma();
		sagoma.setImg(pathImg);
		try {
			DAOFactory.getDAOFactory().getSagomaDAO().save(sagoma);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sagoma;
	}
	@Override
	public LavorazionePezzo creaLavorazionePezzo() {
		LavorazionePezzo lavorazionePezzo = DAOFactory.getDAOFactory().getLavorazionePezzoDAO().createLavorazionePezzo();
		try {
			DAOFactory.getDAOFactory().getLavorazionePezzoDAO().save(lavorazionePezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lavorazionePezzo;
	}
	@Override
	public LavorazionePezzo creaLavorazionePezzo(String descrizione,
			float misuraTaglio, float pesoPezzoLavorato, Sagoma sagoma) {
		LavorazionePezzo lavorazionePezzo = DAOFactory.getDAOFactory().getLavorazionePezzoDAO().createLavorazionePezzo();
		lavorazionePezzo.setDescrizione(descrizione);
		lavorazionePezzo.setMisuraDiTaglio(misuraTaglio);
		lavorazionePezzo.setPeso(pesoPezzoLavorato);
		lavorazionePezzo.setSagoma(sagoma);
		try {
			DAOFactory.getDAOFactory().getLavorazionePezzoDAO().save(lavorazionePezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lavorazionePezzo;
	}

}
