/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class ListCoedil99Data {
	private static final int ROW_COUNT = 100;
	
public void listTestData() throws PersistentException {
		com.coedil99.modello_di_dominio.DAOFactory lDAOFactory = com.coedil99.modello_di_dominio.DAOFactory.getDAOFactory();
		System.out.println("Listing Commessa...");
		com.coedil99.modello_di_dominio.Commessa[] comcoedil99modello_di_dominioCommessas = lDAOFactory.getCommessaDAO().listCommessaByQuery(null, null);
		int length = Math.min(comcoedil99modello_di_dominioCommessas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioCommessas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Distinta...");
		com.coedil99.modello_di_dominio.Distinta[] comcoedil99modello_di_dominioDistintas = lDAOFactory.getDistintaDAO().listDistintaByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioDistintas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioDistintas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ordine...");
		com.coedil99.modello_di_dominio.Ordine[] comcoedil99modello_di_dominioOrdines = lDAOFactory.getOrdineDAO().listOrdineByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioOrdines.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioOrdines[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pezzo...");
		com.coedil99.modello_di_dominio.Pezzo[] comcoedil99modello_di_dominioPezzos = lDAOFactory.getPezzoDAO().listPezzoByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioPezzos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioPezzos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing DescrizionePezzo...");
		com.coedil99.modello_di_dominio.DescrizionePezzo[] comcoedil99modello_di_dominioDescrizionePezzos = lDAOFactory.getDescrizionePezzoDAO().listDescrizionePezzoByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioDescrizionePezzos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioDescrizionePezzos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RigaDistinta...");
		com.coedil99.modello_di_dominio.RigaDistinta[] comcoedil99modello_di_dominioRigaDistintas = lDAOFactory.getRigaDistintaDAO().listRigaDistintaByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioRigaDistintas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioRigaDistintas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing LavorazionePezzo...");
		com.coedil99.modello_di_dominio.LavorazionePezzo[] comcoedil99modello_di_dominioLavorazionePezzos = lDAOFactory.getLavorazionePezzoDAO().listLavorazionePezzoByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioLavorazionePezzos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioLavorazionePezzos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Destinazione...");
		com.coedil99.modello_di_dominio.Destinazione[] comcoedil99modello_di_dominioDestinaziones = lDAOFactory.getDestinazioneDAO().listDestinazioneByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioDestinaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioDestinaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sagoma...");
		com.coedil99.modello_di_dominio.Sagoma[] comcoedil99modello_di_dominioSagomas = lDAOFactory.getSagomaDAO().listSagomaByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioSagomas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioSagomas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RDA...");
		com.coedil99.modello_di_dominio.RDA[] comcoedil99modello_di_dominioRDAs = lDAOFactory.getRDADAO().listRDAByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioRDAs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioRDAs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RigaRDA...");
		com.coedil99.modello_di_dominio.RigaRDA[] comcoedil99modello_di_dominioRigaRDAs = lDAOFactory.getRigaRDADAO().listRigaRDAByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioRigaRDAs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioRigaRDAs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Fornitore...");
		com.coedil99.modello_di_dominio.Fornitore[] comcoedil99modello_di_dominioFornitores = lDAOFactory.getFornitoreDAO().listFornitoreByQuery(null, null);
		length = Math.min(comcoedil99modello_di_dominioFornitores.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comcoedil99modello_di_dominioFornitores[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Commessa by Criteria...");
		com.coedil99.modello_di_dominio.CommessaCriteria lcomcoedil99modello_di_dominioCommessaCriteria = new com.coedil99.modello_di_dominio.CommessaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioCommessaCriteria.ID.eq();
		lcomcoedil99modello_di_dominioCommessaCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.Commessa[] comcoedil99modello_di_dominioCommessas = lcomcoedil99modello_di_dominioCommessaCriteria.listCommessa();
		int length =comcoedil99modello_di_dominioCommessas== null ? 0 : Math.min(comcoedil99modello_di_dominioCommessas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioCommessas[i]);
		}
		System.out.println(length + " Commessa record(s) retrieved."); 
		
		System.out.println("Listing Distinta by Criteria...");
		com.coedil99.modello_di_dominio.DistintaCriteria lcomcoedil99modello_di_dominioDistintaCriteria = new com.coedil99.modello_di_dominio.DistintaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioDistintaCriteria.ID.eq();
		lcomcoedil99modello_di_dominioDistintaCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.Distinta[] comcoedil99modello_di_dominioDistintas = lcomcoedil99modello_di_dominioDistintaCriteria.listDistinta();
		length =comcoedil99modello_di_dominioDistintas== null ? 0 : Math.min(comcoedil99modello_di_dominioDistintas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioDistintas[i]);
		}
		System.out.println(length + " Distinta record(s) retrieved."); 
		
		System.out.println("Listing Ordine by Criteria...");
		com.coedil99.modello_di_dominio.OrdineCriteria lcomcoedil99modello_di_dominioOrdineCriteria = new com.coedil99.modello_di_dominio.OrdineCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioOrdineCriteria.ID.eq();
		lcomcoedil99modello_di_dominioOrdineCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.Ordine[] comcoedil99modello_di_dominioOrdines = lcomcoedil99modello_di_dominioOrdineCriteria.listOrdine();
		length =comcoedil99modello_di_dominioOrdines== null ? 0 : Math.min(comcoedil99modello_di_dominioOrdines.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioOrdines[i]);
		}
		System.out.println(length + " Ordine record(s) retrieved."); 
		
		System.out.println("Listing Pezzo by Criteria...");
		com.coedil99.modello_di_dominio.PezzoCriteria lcomcoedil99modello_di_dominioPezzoCriteria = new com.coedil99.modello_di_dominio.PezzoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioPezzoCriteria.ID.eq();
		lcomcoedil99modello_di_dominioPezzoCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.Pezzo[] comcoedil99modello_di_dominioPezzos = lcomcoedil99modello_di_dominioPezzoCriteria.listPezzo();
		length =comcoedil99modello_di_dominioPezzos== null ? 0 : Math.min(comcoedil99modello_di_dominioPezzos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioPezzos[i]);
		}
		System.out.println(length + " Pezzo record(s) retrieved."); 
		
		System.out.println("Listing DescrizionePezzo by Criteria...");
		com.coedil99.modello_di_dominio.DescrizionePezzoCriteria lcomcoedil99modello_di_dominioDescrizionePezzoCriteria = new com.coedil99.modello_di_dominio.DescrizionePezzoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioDescrizionePezzoCriteria.ID.eq();
		lcomcoedil99modello_di_dominioDescrizionePezzoCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.DescrizionePezzo[] comcoedil99modello_di_dominioDescrizionePezzos = lcomcoedil99modello_di_dominioDescrizionePezzoCriteria.listDescrizionePezzo();
		length =comcoedil99modello_di_dominioDescrizionePezzos== null ? 0 : Math.min(comcoedil99modello_di_dominioDescrizionePezzos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioDescrizionePezzos[i]);
		}
		System.out.println(length + " DescrizionePezzo record(s) retrieved."); 
		
		System.out.println("Listing RigaDistinta by Criteria...");
		com.coedil99.modello_di_dominio.RigaDistintaCriteria lcomcoedil99modello_di_dominioRigaDistintaCriteria = new com.coedil99.modello_di_dominio.RigaDistintaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioRigaDistintaCriteria.ID.eq();
		lcomcoedil99modello_di_dominioRigaDistintaCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.RigaDistinta[] comcoedil99modello_di_dominioRigaDistintas = lcomcoedil99modello_di_dominioRigaDistintaCriteria.listRigaDistinta();
		length =comcoedil99modello_di_dominioRigaDistintas== null ? 0 : Math.min(comcoedil99modello_di_dominioRigaDistintas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioRigaDistintas[i]);
		}
		System.out.println(length + " RigaDistinta record(s) retrieved."); 
		
		System.out.println("Listing LavorazionePezzo by Criteria...");
		com.coedil99.modello_di_dominio.LavorazionePezzoCriteria lcomcoedil99modello_di_dominioLavorazionePezzoCriteria = new com.coedil99.modello_di_dominio.LavorazionePezzoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioLavorazionePezzoCriteria.ID.eq();
		lcomcoedil99modello_di_dominioLavorazionePezzoCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.LavorazionePezzo[] comcoedil99modello_di_dominioLavorazionePezzos = lcomcoedil99modello_di_dominioLavorazionePezzoCriteria.listLavorazionePezzo();
		length =comcoedil99modello_di_dominioLavorazionePezzos== null ? 0 : Math.min(comcoedil99modello_di_dominioLavorazionePezzos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioLavorazionePezzos[i]);
		}
		System.out.println(length + " LavorazionePezzo record(s) retrieved."); 
		
		System.out.println("Listing Destinazione by Criteria...");
		com.coedil99.modello_di_dominio.DestinazioneCriteria lcomcoedil99modello_di_dominioDestinazioneCriteria = new com.coedil99.modello_di_dominio.DestinazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioDestinazioneCriteria.ID.eq();
		lcomcoedil99modello_di_dominioDestinazioneCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.Destinazione[] comcoedil99modello_di_dominioDestinaziones = lcomcoedil99modello_di_dominioDestinazioneCriteria.listDestinazione();
		length =comcoedil99modello_di_dominioDestinaziones== null ? 0 : Math.min(comcoedil99modello_di_dominioDestinaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioDestinaziones[i]);
		}
		System.out.println(length + " Destinazione record(s) retrieved."); 
		
		System.out.println("Listing Sagoma by Criteria...");
		com.coedil99.modello_di_dominio.SagomaCriteria lcomcoedil99modello_di_dominioSagomaCriteria = new com.coedil99.modello_di_dominio.SagomaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioSagomaCriteria.ID.eq();
		lcomcoedil99modello_di_dominioSagomaCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.Sagoma[] comcoedil99modello_di_dominioSagomas = lcomcoedil99modello_di_dominioSagomaCriteria.listSagoma();
		length =comcoedil99modello_di_dominioSagomas== null ? 0 : Math.min(comcoedil99modello_di_dominioSagomas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioSagomas[i]);
		}
		System.out.println(length + " Sagoma record(s) retrieved."); 
		
		System.out.println("Listing RDA by Criteria...");
		com.coedil99.modello_di_dominio.RDACriteria lcomcoedil99modello_di_dominioRDACriteria = new com.coedil99.modello_di_dominio.RDACriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioRDACriteria.ID.eq();
		lcomcoedil99modello_di_dominioRDACriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.RDA[] comcoedil99modello_di_dominioRDAs = lcomcoedil99modello_di_dominioRDACriteria.listRDA();
		length =comcoedil99modello_di_dominioRDAs== null ? 0 : Math.min(comcoedil99modello_di_dominioRDAs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioRDAs[i]);
		}
		System.out.println(length + " RDA record(s) retrieved."); 
		
		System.out.println("Listing RigaRDA by Criteria...");
		com.coedil99.modello_di_dominio.RigaRDACriteria lcomcoedil99modello_di_dominioRigaRDACriteria = new com.coedil99.modello_di_dominio.RigaRDACriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioRigaRDACriteria.ID.eq();
		lcomcoedil99modello_di_dominioRigaRDACriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.RigaRDA[] comcoedil99modello_di_dominioRigaRDAs = lcomcoedil99modello_di_dominioRigaRDACriteria.listRigaRDA();
		length =comcoedil99modello_di_dominioRigaRDAs== null ? 0 : Math.min(comcoedil99modello_di_dominioRigaRDAs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioRigaRDAs[i]);
		}
		System.out.println(length + " RigaRDA record(s) retrieved."); 
		
		System.out.println("Listing Fornitore by Criteria...");
		com.coedil99.modello_di_dominio.FornitoreCriteria lcomcoedil99modello_di_dominioFornitoreCriteria = new com.coedil99.modello_di_dominio.FornitoreCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomcoedil99modello_di_dominioFornitoreCriteria.ID.eq();
		lcomcoedil99modello_di_dominioFornitoreCriteria.setMaxResults(ROW_COUNT);
		com.coedil99.modello_di_dominio.Fornitore[] comcoedil99modello_di_dominioFornitores = lcomcoedil99modello_di_dominioFornitoreCriteria.listFornitore();
		length =comcoedil99modello_di_dominioFornitores== null ? 0 : Math.min(comcoedil99modello_di_dominioFornitores.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comcoedil99modello_di_dominioFornitores[i]);
		}
		System.out.println(length + " Fornitore record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListCoedil99Data listCoedil99Data = new ListCoedil99Data();
			try {
				listCoedil99Data.listTestData();
				//listCoedil99Data.listByCriteria();
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
