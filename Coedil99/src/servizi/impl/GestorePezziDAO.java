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
    public Pezzo modificaPezzoByID(int idPezzo, DescrizionePezzo descPrezzo, Date dataArrivo, int quantita) {
        Pezzo pezzo = null;
        try {
            pezzo = pezzoDAO.getPezzoByORMID(idPezzo);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        pezzo = modificaPezzo(pezzo, descPrezzo, dataArrivo, quantita);
        return pezzo;
    }

    @Override
    public Pezzo modificaPezzo(Pezzo pezzo, DescrizionePezzo descPrezzo, Date dataArrivo, int quantita) {
        pezzo.setDescrizionePezzo(descPrezzo);
        pezzo.setDataArrivo(dataArrivo);
        pezzo.setQuantita(quantita);
        try {
            pezzoDAO.save(pezzo);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return pezzo;
    }

    @Override
    public DescrizionePezzo modificaDescrizionePezzo(DescrizionePezzo descrizionePezzo, String nome, float peso, float diametro, String fornitore) {
        descrizionePezzo.setNome(nome);
        descrizionePezzo.setPeso(peso);
        descrizionePezzo.setDiametro(diametro);
        descrizionePezzo.setFornitore(fornitore);
        try {
            DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(descrizionePezzo);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return descrizionePezzo;
    }

    @Override
    public DescrizionePezzo modificaDescrizionePezzobyID(int idDescrizionePezzo, String nome, float peso, float diametro, String fornitore) {
        DescrizionePezzo descrizionePezzo = null;
        try {
            descrizionePezzo = modificaDescrizionePezzo(DAOFactory.getDAOFactory().getDescrizionePezzoDAO().getDescrizionePezzoByORMID(idDescrizionePezzo), nome, peso, diametro, fornitore);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return descrizionePezzo;
    }


}
