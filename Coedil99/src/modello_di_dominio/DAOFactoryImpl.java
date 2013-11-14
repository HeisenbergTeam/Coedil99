/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Faculty of informatics, Burapha University 01
 * License Type: Purchased
 */
package modello_di_dominio;

import modello_di_dominio.impl.*;
import modello_di_dominio.dao.*;

public class DAOFactoryImpl extends DAOFactory {
	private CommessaDAO _commessaDAO = new CommessaDAOImpl();
	public CommessaDAO getCommessaDAO() {
		return _commessaDAO;
	}
	
	private DistintaDAO _distintaDAO = new DistintaDAOImpl();
	public DistintaDAO getDistintaDAO() {
		return _distintaDAO;
	}
	
	private OrdineDAO _ordineDAO = new OrdineDAOImpl();
	public OrdineDAO getOrdineDAO() {
		return _ordineDAO;
	}
	
	private PezzoDAO _pezzoDAO = new PezzoDAOImpl();
	public PezzoDAO getPezzoDAO() {
		return _pezzoDAO;
	}
	
	private DescrizionePezzoDAO _descrizionePezzoDAO = new DescrizionePezzoDAOImpl();
	public DescrizionePezzoDAO getDescrizionePezzoDAO() {
		return _descrizionePezzoDAO;
	}
	
	private RigaDistintaDAO _rigaDistintaDAO = new RigaDistintaDAOImpl();
	public RigaDistintaDAO getRigaDistintaDAO() {
		return _rigaDistintaDAO;
	}
	
	private LavorazionePezzoDAO _lavorazionePezzoDAO = new LavorazionePezzoDAOImpl();
	public LavorazionePezzoDAO getLavorazionePezzoDAO() {
		return _lavorazionePezzoDAO;
	}
	
	private DestinazioneDAO _destinazioneDAO = new DestinazioneDAOImpl();
	public DestinazioneDAO getDestinazioneDAO() {
		return _destinazioneDAO;
	}
	
	private SagomaDAO _sagomaDAO = new SagomaDAOImpl();
	public SagomaDAO getSagomaDAO() {
		return _sagomaDAO;
	}
	
}

