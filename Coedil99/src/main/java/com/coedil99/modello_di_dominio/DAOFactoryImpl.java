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
    private DistintaDAO _distintaDAO = new DistintaDAOImpl();
    private OrdineDAO _ordineDAO = new OrdineDAOImpl();
    private PezzoDAO _pezzoDAO = new PezzoDAOImpl();
    private DescrizionePezzoDAO _descrizionePezzoDAO = new DescrizionePezzoDAOImpl();
    private RigaDistintaDAO _rigaDistintaDAO = new RigaDistintaDAOImpl();
    private LavorazionePezzoDAO _lavorazionePezzoDAO = new LavorazionePezzoDAOImpl();
    private DestinazioneDAO _destinazioneDAO = new DestinazioneDAOImpl();
    private SagomaDAO _sagomaDAO = new SagomaDAOImpl();
    private RDADAO _rDADAO = new RDADAOImpl();
    private RigaRDADAO _rigaRDADAO = new RigaRDADAOImpl();
    private FornitoreDAO _fornitoreDAO = new FornitoreDAOImpl();

    public CommessaDAO getCommessaDAO() {
        return _commessaDAO;
    }

    public DistintaDAO getDistintaDAO() {
        return _distintaDAO;
    }

    public OrdineDAO getOrdineDAO() {
        return _ordineDAO;
    }

    public PezzoDAO getPezzoDAO() {
        return _pezzoDAO;
    }

    public DescrizionePezzoDAO getDescrizionePezzoDAO() {
        return _descrizionePezzoDAO;
    }

    public RigaDistintaDAO getRigaDistintaDAO() {
        return _rigaDistintaDAO;
    }

    public LavorazionePezzoDAO getLavorazionePezzoDAO() {
        return _lavorazionePezzoDAO;
    }

    public DestinazioneDAO getDestinazioneDAO() {
        return _destinazioneDAO;
    }

    public SagomaDAO getSagomaDAO() {
        return _sagomaDAO;
    }

    public RDADAO getRDADAO() {
        return _rDADAO;
    }

    public RigaRDADAO getRigaRDADAO() {
        return _rigaRDADAO;
    }

    public FornitoreDAO getFornitoreDAO() {
        return _fornitoreDAO;
    }

}

