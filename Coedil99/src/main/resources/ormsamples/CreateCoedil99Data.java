/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateCoedil99Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().beginTransaction();
		try {
			com.coedil99.modello_di_dominio.DAOFactory lDAOFactory = com.coedil99.modello_di_dominio.DAOFactory.getDAOFactory();
			com.coedil99.modello_di_dominio.dao.CommessaDAO lcomcoedil99modello_di_dominioCommessaDAO = lDAOFactory.getCommessaDAO();
			com.coedil99.modello_di_dominio.Commessa lcomcoedil99modello_di_dominioCommessa = lcomcoedil99modello_di_dominioCommessaDAO.createCommessa();
			// Initialize the properties of the persistent object here
			lcomcoedil99modello_di_dominioCommessaDAO.save(lcomcoedil99modello_di_dominioCommessa);
			com.coedil99.modello_di_dominio.dao.DistintaDAO lcomcoedil99modello_di_dominioDistintaDAO = lDAOFactory.getDistintaDAO();
			com.coedil99.modello_di_dominio.Distinta lcomcoedil99modello_di_dominioDistinta = lcomcoedil99modello_di_dominioDistintaDAO.createDistinta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : righeDistinta, revisione
			lcomcoedil99modello_di_dominioDistintaDAO.save(lcomcoedil99modello_di_dominioDistinta);
			com.coedil99.modello_di_dominio.dao.OrdineDAO lcomcoedil99modello_di_dominioOrdineDAO = lDAOFactory.getOrdineDAO();
			com.coedil99.modello_di_dominio.Ordine lcomcoedil99modello_di_dominioOrdine = lcomcoedil99modello_di_dominioOrdineDAO.createOrdine();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : destinazione
			lcomcoedil99modello_di_dominioOrdineDAO.save(lcomcoedil99modello_di_dominioOrdine);
			com.coedil99.modello_di_dominio.dao.PezzoDAO lcomcoedil99modello_di_dominioPezzoDAO = lDAOFactory.getPezzoDAO();
			com.coedil99.modello_di_dominio.Pezzo lcomcoedil99modello_di_dominioPezzo = lcomcoedil99modello_di_dominioPezzoDAO.createPezzo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rigaRDA, descrizionePezzo
			lcomcoedil99modello_di_dominioPezzoDAO.save(lcomcoedil99modello_di_dominioPezzo);
			com.coedil99.modello_di_dominio.dao.DescrizionePezzoDAO lcomcoedil99modello_di_dominioDescrizionePezzoDAO = lDAOFactory.getDescrizionePezzoDAO();
			com.coedil99.modello_di_dominio.DescrizionePezzo lcomcoedil99modello_di_dominioDescrizionePezzo = lcomcoedil99modello_di_dominioDescrizionePezzoDAO.createDescrizionePezzo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : lavorazionePezzo, peso, diametro, fornitore
			lcomcoedil99modello_di_dominioDescrizionePezzoDAO.save(lcomcoedil99modello_di_dominioDescrizionePezzo);
			com.coedil99.modello_di_dominio.dao.RigaDistintaDAO lcomcoedil99modello_di_dominioRigaDistintaDAO = lDAOFactory.getRigaDistintaDAO();
			com.coedil99.modello_di_dominio.RigaDistinta lcomcoedil99modello_di_dominioRigaDistinta = lcomcoedil99modello_di_dominioRigaDistintaDAO.createRigaDistinta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : quantitaUtilizzata, lavorazionePezzo, distinta, pezzo
			lcomcoedil99modello_di_dominioRigaDistintaDAO.save(lcomcoedil99modello_di_dominioRigaDistinta);
			com.coedil99.modello_di_dominio.dao.LavorazionePezzoDAO lcomcoedil99modello_di_dominioLavorazionePezzoDAO = lDAOFactory.getLavorazionePezzoDAO();
			com.coedil99.modello_di_dominio.LavorazionePezzo lcomcoedil99modello_di_dominioLavorazionePezzo = lcomcoedil99modello_di_dominioLavorazionePezzoDAO.createLavorazionePezzo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : peso, misuraDiTaglio
			lcomcoedil99modello_di_dominioLavorazionePezzoDAO.save(lcomcoedil99modello_di_dominioLavorazionePezzo);
			com.coedil99.modello_di_dominio.dao.DestinazioneDAO lcomcoedil99modello_di_dominioDestinazioneDAO = lDAOFactory.getDestinazioneDAO();
			com.coedil99.modello_di_dominio.Destinazione lcomcoedil99modello_di_dominioDestinazione = lcomcoedil99modello_di_dominioDestinazioneDAO.createDestinazione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : ordine
			lcomcoedil99modello_di_dominioDestinazioneDAO.save(lcomcoedil99modello_di_dominioDestinazione);
			com.coedil99.modello_di_dominio.dao.SagomaDAO lcomcoedil99modello_di_dominioSagomaDAO = lDAOFactory.getSagomaDAO();
			com.coedil99.modello_di_dominio.Sagoma lcomcoedil99modello_di_dominioSagoma = lcomcoedil99modello_di_dominioSagomaDAO.createSagoma();
			// Initialize the properties of the persistent object here
			lcomcoedil99modello_di_dominioSagomaDAO.save(lcomcoedil99modello_di_dominioSagoma);
			com.coedil99.modello_di_dominio.dao.RDADAO lcomcoedil99modello_di_dominioRDADAO = lDAOFactory.getRDADAO();
			com.coedil99.modello_di_dominio.RDA lcomcoedil99modello_di_dominioRDA = lcomcoedil99modello_di_dominioRDADAO.createRDA();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : righeRDA, fornitore
			lcomcoedil99modello_di_dominioRDADAO.save(lcomcoedil99modello_di_dominioRDA);
			com.coedil99.modello_di_dominio.dao.RigaRDADAO lcomcoedil99modello_di_dominioRigaRDADAO = lDAOFactory.getRigaRDADAO();
			com.coedil99.modello_di_dominio.RigaRDA lcomcoedil99modello_di_dominioRigaRDA = lcomcoedil99modello_di_dominioRigaRDADAO.createRigaRDA();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : quantitaPezziOrdinati, rda, pezzo
			lcomcoedil99modello_di_dominioRigaRDADAO.save(lcomcoedil99modello_di_dominioRigaRDA);
			com.coedil99.modello_di_dominio.dao.FornitoreDAO lcomcoedil99modello_di_dominioFornitoreDAO = lDAOFactory.getFornitoreDAO();
			com.coedil99.modello_di_dominio.Fornitore lcomcoedil99modello_di_dominioFornitore = lcomcoedil99modello_di_dominioFornitoreDAO.createFornitore();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : descrizionePezzo, rda
			lcomcoedil99modello_di_dominioFornitoreDAO.save(lcomcoedil99modello_di_dominioFornitore);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateCoedil99Data createCoedil99Data = new CreateCoedil99Data();
			try {
				createCoedil99Data.createTestData();
			}
			finally {
				com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
