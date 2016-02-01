package com.coedil99.modello_di_dominio;

import com.coedil99.modello_di_dominio.dao.*;
import com.coedil99.modello_di_dominio.rest.*;

/**
 * Created by Igor on 01/02/2016.
 */
public class DAOFactoryRestImpl extends DAOFactory {
    @Override
    public CommessaDAO getCommessaDAO() {
        return new CommessaDAOImpl();
    }

    @Override
    public DistintaDAO getDistintaDAO() {
        return new DistintaDAOImpl();
    }

    @Override
    public OrdineDAO getOrdineDAO() {
        return new OrdineDAOImpl();
    }

    @Override
    public PezzoDAO getPezzoDAO() {
        return new PezzoDAOImpl();
    }

    @Override
    public DescrizionePezzoDAO getDescrizionePezzoDAO() {
        return new DescrizionePezzoDAOImpl();
    }

    @Override
    public RigaDistintaDAO getRigaDistintaDAO() {
        return new RigaDistintaDAOImpl();
    }

    @Override
    public LavorazionePezzoDAO getLavorazionePezzoDAO() {
        return new LavorazionePezzoDAOImpl();
    }

    @Override
    public DestinazioneDAO getDestinazioneDAO() {
        return new DestinazioneDAOImpl();
    }

    @Override
    public SagomaDAO getSagomaDAO() {
        return new SagomaDAOImpl();
    }

    @Override
    public RDADAO getRDADAO() {
        return new RDADAOImpl();
    }

    @Override
    public RigaRDADAO getRigaRDADAO() {
        return new RigaRDADAOImpl();
    }

    @Override
    public FornitoreDAO getFornitoreDAO() {
        return new FornitoreDAOImpl();
    }
}
