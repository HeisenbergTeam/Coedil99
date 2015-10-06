/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateCoedil99Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().beginTransaction();
		try {
			com.coedil99.modello_di_dominio.DAOFactory lDAOFactory = com.coedil99.modello_di_dominio.DAOFactory.getDAOFactory();
			com.coedil99.modello_di_dominio.dao.CommessaDAO lcomcoedil99modello_di_dominioCommessaDAO = lDAOFactory.getCommessaDAO();
			com.coedil99.modello_di_dominio.Commessa lcomcoedil99modello_di_dominioCommessa = lcomcoedil99modello_di_dominioCommessaDAO.loadCommessaByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioCommessaDAO.save(lcomcoedil99modello_di_dominioCommessa);
			com.coedil99.modello_di_dominio.dao.DistintaDAO lcomcoedil99modello_di_dominioDistintaDAO = lDAOFactory.getDistintaDAO();
			com.coedil99.modello_di_dominio.Distinta lcomcoedil99modello_di_dominioDistinta = lcomcoedil99modello_di_dominioDistintaDAO.loadDistintaByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioDistintaDAO.save(lcomcoedil99modello_di_dominioDistinta);
			com.coedil99.modello_di_dominio.dao.OrdineDAO lcomcoedil99modello_di_dominioOrdineDAO = lDAOFactory.getOrdineDAO();
			com.coedil99.modello_di_dominio.Ordine lcomcoedil99modello_di_dominioOrdine = lcomcoedil99modello_di_dominioOrdineDAO.loadOrdineByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioOrdineDAO.save(lcomcoedil99modello_di_dominioOrdine);
			com.coedil99.modello_di_dominio.dao.PezzoDAO lcomcoedil99modello_di_dominioPezzoDAO = lDAOFactory.getPezzoDAO();
			com.coedil99.modello_di_dominio.Pezzo lcomcoedil99modello_di_dominioPezzo = lcomcoedil99modello_di_dominioPezzoDAO.loadPezzoByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioPezzoDAO.save(lcomcoedil99modello_di_dominioPezzo);
			com.coedil99.modello_di_dominio.dao.DescrizionePezzoDAO lcomcoedil99modello_di_dominioDescrizionePezzoDAO = lDAOFactory.getDescrizionePezzoDAO();
			com.coedil99.modello_di_dominio.DescrizionePezzo lcomcoedil99modello_di_dominioDescrizionePezzo = lcomcoedil99modello_di_dominioDescrizionePezzoDAO.loadDescrizionePezzoByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioDescrizionePezzoDAO.save(lcomcoedil99modello_di_dominioDescrizionePezzo);
			com.coedil99.modello_di_dominio.dao.RigaDistintaDAO lcomcoedil99modello_di_dominioRigaDistintaDAO = lDAOFactory.getRigaDistintaDAO();
			com.coedil99.modello_di_dominio.RigaDistinta lcomcoedil99modello_di_dominioRigaDistinta = lcomcoedil99modello_di_dominioRigaDistintaDAO.loadRigaDistintaByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioRigaDistintaDAO.save(lcomcoedil99modello_di_dominioRigaDistinta);
			com.coedil99.modello_di_dominio.dao.LavorazionePezzoDAO lcomcoedil99modello_di_dominioLavorazionePezzoDAO = lDAOFactory.getLavorazionePezzoDAO();
			com.coedil99.modello_di_dominio.LavorazionePezzo lcomcoedil99modello_di_dominioLavorazionePezzo = lcomcoedil99modello_di_dominioLavorazionePezzoDAO.loadLavorazionePezzoByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioLavorazionePezzoDAO.save(lcomcoedil99modello_di_dominioLavorazionePezzo);
			com.coedil99.modello_di_dominio.dao.DestinazioneDAO lcomcoedil99modello_di_dominioDestinazioneDAO = lDAOFactory.getDestinazioneDAO();
			com.coedil99.modello_di_dominio.Destinazione lcomcoedil99modello_di_dominioDestinazione = lcomcoedil99modello_di_dominioDestinazioneDAO.loadDestinazioneByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioDestinazioneDAO.save(lcomcoedil99modello_di_dominioDestinazione);
			com.coedil99.modello_di_dominio.dao.SagomaDAO lcomcoedil99modello_di_dominioSagomaDAO = lDAOFactory.getSagomaDAO();
			com.coedil99.modello_di_dominio.Sagoma lcomcoedil99modello_di_dominioSagoma = lcomcoedil99modello_di_dominioSagomaDAO.loadSagomaByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioSagomaDAO.save(lcomcoedil99modello_di_dominioSagoma);
			com.coedil99.modello_di_dominio.dao.RDADAO lcomcoedil99modello_di_dominioRDADAO = lDAOFactory.getRDADAO();
			com.coedil99.modello_di_dominio.RDA lcomcoedil99modello_di_dominioRDA = lcomcoedil99modello_di_dominioRDADAO.loadRDAByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioRDADAO.save(lcomcoedil99modello_di_dominioRDA);
			com.coedil99.modello_di_dominio.dao.RigaRDADAO lcomcoedil99modello_di_dominioRigaRDADAO = lDAOFactory.getRigaRDADAO();
			com.coedil99.modello_di_dominio.RigaRDA lcomcoedil99modello_di_dominioRigaRDA = lcomcoedil99modello_di_dominioRigaRDADAO.loadRigaRDAByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioRigaRDADAO.save(lcomcoedil99modello_di_dominioRigaRDA);
			com.coedil99.modello_di_dominio.dao.FornitoreDAO lcomcoedil99modello_di_dominioFornitoreDAO = lDAOFactory.getFornitoreDAO();
			com.coedil99.modello_di_dominio.Fornitore lcomcoedil99modello_di_dominioFornitore = lcomcoedil99modello_di_dominioFornitoreDAO.loadFornitoreByQuery(null, null);
			// Update the properties of the persistent object
			lcomcoedil99modello_di_dominioFornitoreDAO.save(lcomcoedil99modello_di_dominioFornitore);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Commessa by CommessaCriteria");
		com.coedil99.modello_di_dominio.CommessaCriteria lcomcoedil99modello_di_dominioCommessaCriteria = new com.coedil99.modello_di_dominio.CommessaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioCommessaCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioCommessaCriteria.uniqueCommessa());
		
		System.out.println("Retrieving Distinta by DistintaCriteria");
		com.coedil99.modello_di_dominio.DistintaCriteria lcomcoedil99modello_di_dominioDistintaCriteria = new com.coedil99.modello_di_dominio.DistintaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioDistintaCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioDistintaCriteria.uniqueDistinta());
		
		System.out.println("Retrieving Ordine by OrdineCriteria");
		com.coedil99.modello_di_dominio.OrdineCriteria lcomcoedil99modello_di_dominioOrdineCriteria = new com.coedil99.modello_di_dominio.OrdineCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioOrdineCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioOrdineCriteria.uniqueOrdine());
		
		System.out.println("Retrieving Pezzo by PezzoCriteria");
		com.coedil99.modello_di_dominio.PezzoCriteria lcomcoedil99modello_di_dominioPezzoCriteria = new com.coedil99.modello_di_dominio.PezzoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioPezzoCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioPezzoCriteria.uniquePezzo());
		
		System.out.println("Retrieving DescrizionePezzo by DescrizionePezzoCriteria");
		com.coedil99.modello_di_dominio.DescrizionePezzoCriteria lcomcoedil99modello_di_dominioDescrizionePezzoCriteria = new com.coedil99.modello_di_dominio.DescrizionePezzoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioDescrizionePezzoCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioDescrizionePezzoCriteria.uniqueDescrizionePezzo());
		
		System.out.println("Retrieving RigaDistinta by RigaDistintaCriteria");
		com.coedil99.modello_di_dominio.RigaDistintaCriteria lcomcoedil99modello_di_dominioRigaDistintaCriteria = new com.coedil99.modello_di_dominio.RigaDistintaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioRigaDistintaCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioRigaDistintaCriteria.uniqueRigaDistinta());
		
		System.out.println("Retrieving LavorazionePezzo by LavorazionePezzoCriteria");
		com.coedil99.modello_di_dominio.LavorazionePezzoCriteria lcomcoedil99modello_di_dominioLavorazionePezzoCriteria = new com.coedil99.modello_di_dominio.LavorazionePezzoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioLavorazionePezzoCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioLavorazionePezzoCriteria.uniqueLavorazionePezzo());
		
		System.out.println("Retrieving Destinazione by DestinazioneCriteria");
		com.coedil99.modello_di_dominio.DestinazioneCriteria lcomcoedil99modello_di_dominioDestinazioneCriteria = new com.coedil99.modello_di_dominio.DestinazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioDestinazioneCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioDestinazioneCriteria.uniqueDestinazione());
		
		System.out.println("Retrieving Sagoma by SagomaCriteria");
		com.coedil99.modello_di_dominio.SagomaCriteria lcomcoedil99modello_di_dominioSagomaCriteria = new com.coedil99.modello_di_dominio.SagomaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioSagomaCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioSagomaCriteria.uniqueSagoma());
		
		System.out.println("Retrieving RDA by RDACriteria");
		com.coedil99.modello_di_dominio.RDACriteria lcomcoedil99modello_di_dominioRDACriteria = new com.coedil99.modello_di_dominio.RDACriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioRDACriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioRDACriteria.uniqueRDA());
		
		System.out.println("Retrieving RigaRDA by RigaRDACriteria");
		com.coedil99.modello_di_dominio.RigaRDACriteria lcomcoedil99modello_di_dominioRigaRDACriteria = new com.coedil99.modello_di_dominio.RigaRDACriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioRigaRDACriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioRigaRDACriteria.uniqueRigaRDA());
		
		System.out.println("Retrieving Fornitore by FornitoreCriteria");
		com.coedil99.modello_di_dominio.FornitoreCriteria lcomcoedil99modello_di_dominioFornitoreCriteria = new com.coedil99.modello_di_dominio.FornitoreCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomcoedil99modello_di_dominioFornitoreCriteria.ID.eq();
		System.out.println(lcomcoedil99modello_di_dominioFornitoreCriteria.uniqueFornitore());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateCoedil99Data retrieveAndUpdateCoedil99Data = new RetrieveAndUpdateCoedil99Data();
			try {
				retrieveAndUpdateCoedil99Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateCoedil99Data.retrieveByCriteria();
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
