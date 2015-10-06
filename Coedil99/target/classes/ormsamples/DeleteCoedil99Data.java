/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteCoedil99Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().beginTransaction();
		try {
			com.coedil99.modello_di_dominio.DAOFactory lDAOFactory = com.coedil99.modello_di_dominio.DAOFactory.getDAOFactory();
			com.coedil99.modello_di_dominio.dao.CommessaDAO lcomcoedil99modello_di_dominioCommessaDAO = lDAOFactory.getCommessaDAO();
			com.coedil99.modello_di_dominio.Commessa lcomcoedil99modello_di_dominioCommessa = lcomcoedil99modello_di_dominioCommessaDAO.loadCommessaByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioCommessaDAO.delete(lcomcoedil99modello_di_dominioCommessa);
			com.coedil99.modello_di_dominio.dao.DistintaDAO lcomcoedil99modello_di_dominioDistintaDAO = lDAOFactory.getDistintaDAO();
			com.coedil99.modello_di_dominio.Distinta lcomcoedil99modello_di_dominioDistinta = lcomcoedil99modello_di_dominioDistintaDAO.loadDistintaByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioDistintaDAO.delete(lcomcoedil99modello_di_dominioDistinta);
			com.coedil99.modello_di_dominio.dao.OrdineDAO lcomcoedil99modello_di_dominioOrdineDAO = lDAOFactory.getOrdineDAO();
			com.coedil99.modello_di_dominio.Ordine lcomcoedil99modello_di_dominioOrdine = lcomcoedil99modello_di_dominioOrdineDAO.loadOrdineByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioOrdineDAO.delete(lcomcoedil99modello_di_dominioOrdine);
			com.coedil99.modello_di_dominio.dao.PezzoDAO lcomcoedil99modello_di_dominioPezzoDAO = lDAOFactory.getPezzoDAO();
			com.coedil99.modello_di_dominio.Pezzo lcomcoedil99modello_di_dominioPezzo = lcomcoedil99modello_di_dominioPezzoDAO.loadPezzoByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioPezzoDAO.delete(lcomcoedil99modello_di_dominioPezzo);
			com.coedil99.modello_di_dominio.dao.DescrizionePezzoDAO lcomcoedil99modello_di_dominioDescrizionePezzoDAO = lDAOFactory.getDescrizionePezzoDAO();
			com.coedil99.modello_di_dominio.DescrizionePezzo lcomcoedil99modello_di_dominioDescrizionePezzo = lcomcoedil99modello_di_dominioDescrizionePezzoDAO.loadDescrizionePezzoByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioDescrizionePezzoDAO.delete(lcomcoedil99modello_di_dominioDescrizionePezzo);
			com.coedil99.modello_di_dominio.dao.RigaDistintaDAO lcomcoedil99modello_di_dominioRigaDistintaDAO = lDAOFactory.getRigaDistintaDAO();
			com.coedil99.modello_di_dominio.RigaDistinta lcomcoedil99modello_di_dominioRigaDistinta = lcomcoedil99modello_di_dominioRigaDistintaDAO.loadRigaDistintaByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioRigaDistintaDAO.delete(lcomcoedil99modello_di_dominioRigaDistinta);
			com.coedil99.modello_di_dominio.dao.LavorazionePezzoDAO lcomcoedil99modello_di_dominioLavorazionePezzoDAO = lDAOFactory.getLavorazionePezzoDAO();
			com.coedil99.modello_di_dominio.LavorazionePezzo lcomcoedil99modello_di_dominioLavorazionePezzo = lcomcoedil99modello_di_dominioLavorazionePezzoDAO.loadLavorazionePezzoByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioLavorazionePezzoDAO.delete(lcomcoedil99modello_di_dominioLavorazionePezzo);
			com.coedil99.modello_di_dominio.dao.DestinazioneDAO lcomcoedil99modello_di_dominioDestinazioneDAO = lDAOFactory.getDestinazioneDAO();
			com.coedil99.modello_di_dominio.Destinazione lcomcoedil99modello_di_dominioDestinazione = lcomcoedil99modello_di_dominioDestinazioneDAO.loadDestinazioneByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioDestinazioneDAO.delete(lcomcoedil99modello_di_dominioDestinazione);
			com.coedil99.modello_di_dominio.dao.SagomaDAO lcomcoedil99modello_di_dominioSagomaDAO = lDAOFactory.getSagomaDAO();
			com.coedil99.modello_di_dominio.Sagoma lcomcoedil99modello_di_dominioSagoma = lcomcoedil99modello_di_dominioSagomaDAO.loadSagomaByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioSagomaDAO.delete(lcomcoedil99modello_di_dominioSagoma);
			com.coedil99.modello_di_dominio.dao.RDADAO lcomcoedil99modello_di_dominioRDADAO = lDAOFactory.getRDADAO();
			com.coedil99.modello_di_dominio.RDA lcomcoedil99modello_di_dominioRDA = lcomcoedil99modello_di_dominioRDADAO.loadRDAByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioRDADAO.delete(lcomcoedil99modello_di_dominioRDA);
			com.coedil99.modello_di_dominio.dao.RigaRDADAO lcomcoedil99modello_di_dominioRigaRDADAO = lDAOFactory.getRigaRDADAO();
			com.coedil99.modello_di_dominio.RigaRDA lcomcoedil99modello_di_dominioRigaRDA = lcomcoedil99modello_di_dominioRigaRDADAO.loadRigaRDAByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioRigaRDADAO.delete(lcomcoedil99modello_di_dominioRigaRDA);
			com.coedil99.modello_di_dominio.dao.FornitoreDAO lcomcoedil99modello_di_dominioFornitoreDAO = lDAOFactory.getFornitoreDAO();
			com.coedil99.modello_di_dominio.Fornitore lcomcoedil99modello_di_dominioFornitore = lcomcoedil99modello_di_dominioFornitoreDAO.loadFornitoreByQuery(null, null);
			// Delete the persistent object
			lcomcoedil99modello_di_dominioFornitoreDAO.delete(lcomcoedil99modello_di_dominioFornitore);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteCoedil99Data deleteCoedil99Data = new DeleteCoedil99Data();
			try {
				deleteCoedil99Data.deleteTestData();
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
