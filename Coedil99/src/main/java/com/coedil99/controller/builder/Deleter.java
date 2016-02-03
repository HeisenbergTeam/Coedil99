package com.coedil99.controller.builder;

import com.coedil99.modello_di_dominio.*;
import org.orm.PersistentException;

import java.util.Date;

/**
 * Created by me on 2/3/2016.
 */
public class Deleter {


    public void modificaFornitore(Fornitore fornitore, String strNomeFornitore) {
        if (strNomeFornitore != null) {
            fornitore.setNome(strNomeFornitore);
        }
        try {
            DAOFactory.getDAOFactory().getFornitoreDAO().save(fornitore);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }

    public void modificaDescrizionePezzo(DescrizionePezzo descrizionePezzo, String strNomePezzo, Float floatPeso, Float floatDiametro, Fornitore fornitore) {
        if (strNomePezzo != null) {
            descrizionePezzo.setNome(strNomePezzo);
        }
        if (floatPeso != null) {
            descrizionePezzo.setPeso(floatPeso);
        }
        if (floatDiametro != null) {
            descrizionePezzo.setDiametro(floatDiametro);
        }
        if (fornitore != null) {
            descrizionePezzo.setFornitore(fornitore);
        }
        try {
            DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(descrizionePezzo);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }

    public void deleteCommessa(Commessa commessa) {

        try {
            System.out.print(commessa.getID());

            Distinta[] arrayDistinta = DAOFactory.getDAOFactory().getDistintaDAO().listDistintaByQuery("CommessaID = "+commessa.getID(),null);
            System.out.print(arrayDistinta.length);
            for (int i = 0; i < arrayDistinta.length; i++) {
                if (arrayDistinta[i].getCommessa().getID() == commessa.getID()) {
                    System.out.print("deleting distinta " + arrayDistinta[i].getID());
                    DAOFactory.getDAOFactory().getDistintaDAO().deleteAndDissociate(arrayDistinta[i]);
                }
            }
            DAOFactory.getDAOFactory().getCommessaDAO().deleteAndDissociate(commessa);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public void modificaDistinta(Distinta distinta, Date dataInizio, Commessa commessa, String modello, Integer revisione, String elementoStrutturale) {
        if (dataInizio != null) {
            distinta.setDataInizio(dataInizio);
        }
        if (commessa != null) {
            distinta.setCommessa(commessa);
        }
        if (modello != null) {
            distinta.setModello(modello);
        }
        if (revisione != null) {
            distinta.setRevisione(revisione);
        }
        if (elementoStrutturale != null) {
            distinta.setElementoStrutturale(elementoStrutturale);
        }
        try {
            DAOFactory.getDAOFactory().getDistintaDAO().save(distinta);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }

    public void modificaRigaDistinta(RigaDistinta rigaDistinta, Distinta distinta, String indicazione, Pezzo pezzo, LavorazionePezzo lavorazionePezzo, Integer quantitaRigaDistinta) {
        if (distinta != null) {
            rigaDistinta.setDistinta(distinta);
        }
        if (indicazione != null) {
            rigaDistinta.setIndicazione(indicazione);
        }
        if (pezzo != null) {
            rigaDistinta.setPezzo(pezzo);
        }
        if (lavorazionePezzo != null) {
            rigaDistinta.setLavorazionePezzo(lavorazionePezzo);
        }
        if (quantitaRigaDistinta != null) {
            rigaDistinta.setQuantitaRigaDistinta(quantitaRigaDistinta);
        }
        try {
            DAOFactory.getDAOFactory().getRigaDistintaDAO().save(rigaDistinta);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }

    public void modificaDestinazione(Destinazione destinazione, String via) {
        if (via != null) {
            destinazione.setVia(via);
        }
        try {
            DAOFactory.getDAOFactory().getDestinazioneDAO().save(destinazione);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }


    public void deleteOrdine(Ordine ordine) {
        try {
            DAOFactory.getDAOFactory().getOrdineDAO().deleteAndDissociate(ordine);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public void modificaPezzo(Pezzo pezzo, DescrizionePezzo descrizionePezzo, Integer quantitaOrdinate) {
        if (descrizionePezzo != null) {
            pezzo.setDescrizionePezzo(descrizionePezzo);
        }
        if (quantitaOrdinate != null) {
            pezzo.setQuantitaOrdinate(quantitaOrdinate);
        }
        try {
            DAOFactory.getDAOFactory().getPezzoDAO().save(pezzo);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }

    public void deleteRDA(RDA rda) {
        try {
            RigaRDA[] arrayRigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery(null,null);
            for (int i = 0; i < arrayRigaRDA.length; i++) {
                if (arrayRigaRDA[i].getRda().getID() == rda.getID()) {
                    System.out.print("deleting rigarda " + arrayRigaRDA[i].getID());
                    DAOFactory.getDAOFactory().getRigaRDADAO().deleteAndDissociate(arrayRigaRDA[i]);
                }
            }

            DAOFactory.getDAOFactory().getRDADAO().deleteAndDissociate(rda);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public void deleteRigaRDA(RigaRDA rigaRDA, String indicazione, Pezzo pezzo, RDA rda) {
        //TODO
        try {
            DAOFactory.getDAOFactory().getRigaRDADAO().save(rigaRDA);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }


}
