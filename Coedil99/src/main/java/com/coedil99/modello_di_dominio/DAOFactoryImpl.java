/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.coedil99.modello_di_dominio;

import com.coedil99.modello_di_dominio.dao.*;
import com.coedil99.modello_di_dominio.impl.*;

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
	
	private RDADAO _rDADAO = new RDADAOImpl();
	public RDADAO getRDADAO() {
		return _rDADAO;
	}
	
	private RigaRDADAO _rigaRDADAO = new RigaRDADAOImpl();
	public RigaRDADAO getRigaRDADAO() {
		return _rigaRDADAO;
	}
	
	private FornitoreDAO _fornitoreDAO = new FornitoreDAOImpl();
	public FornitoreDAO getFornitoreDAO() {
		return _fornitoreDAO;
	}
	
}

