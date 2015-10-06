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

public abstract class DAOFactory {
	private static DAOFactory _factory = new DAOFactoryImpl();
	
	public static DAOFactory getDAOFactory() {
		return _factory;
	}
	
	public abstract CommessaDAO getCommessaDAO();
	public abstract DistintaDAO getDistintaDAO();
	public abstract OrdineDAO getOrdineDAO();
	public abstract PezzoDAO getPezzoDAO();
	public abstract DescrizionePezzoDAO getDescrizionePezzoDAO();
	public abstract RigaDistintaDAO getRigaDistintaDAO();
	public abstract LavorazionePezzoDAO getLavorazionePezzoDAO();
	public abstract DestinazioneDAO getDestinazioneDAO();
	public abstract SagomaDAO getSagomaDAO();
	public abstract RDADAO getRDADAO();
	public abstract RigaRDADAO getRigaRDADAO();
	public abstract FornitoreDAO getFornitoreDAO();
}

