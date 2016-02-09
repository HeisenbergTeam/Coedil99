package com.coedil99.dominio.builder;

import com.coedil99.modello_di_dominio.*;
import org.orm.PersistentException;

import java.util.Date;

/**
 * Created by me on 2/3/2016.
 */
public class Editor {

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

    public void modificaCommessa(Commessa commessa, Ordine ordine, Integer priorita, Date dataCreazione) {
        if (ordine != null) {
            commessa.setOrdine(ordine);
        }
        if (priorita != null) {
            commessa.setPriorita(priorita);
        }
        if (dataCreazione != null) {
            commessa.setDataCreazione(dataCreazione);
        }
        try {
            DAOFactory.getDAOFactory().getCommessaDAO().save(commessa);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
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


    public void modificaOrdine(Ordine ordine, Date dataCreazione, Destinazione destinazione) {
        if (dataCreazione != null) {
            ordine.setDataCreazione(dataCreazione);
        }
        if (destinazione != null) {
            ordine.setDestinazione(destinazione);
        }
        try {
            DAOFactory.getDAOFactory().getOrdineDAO().save(ordine);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
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

    public void modificaRDA(RDA rda, Fornitore fornitore, String descrizione, Date dataArrivoEffettiva, Date dataArrivoPrevista, Date dataCreazione) {
        if (fornitore != null) {
            rda.setFornitore(fornitore);
        }
        if (descrizione != null) {
            rda.setDescrizione(descrizione);
        }
        if (dataArrivoEffettiva != null) {
            rda.setDataArrivoEffettiva(dataArrivoEffettiva);
        }
        if (dataArrivoPrevista != null) {
            rda.setDataArrivoPrevista(dataArrivoPrevista);
        }
        if (dataCreazione != null) {
            rda.setDataCreazione(dataCreazione);
        }
        try {
            DAOFactory.getDAOFactory().getRDADAO().save(rda);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }

    public void modificaRigaRDA(RigaRDA rigaRDA, String indicazione, Pezzo pezzo, RDA rda) {
        if (indicazione != null) {
            rigaRDA.setIndicazione(indicazione);
        }
        if (pezzo != null) {
            rigaRDA.setPezzo(pezzo);
        }
        if (rda != null) {
            rigaRDA.setRda(rda);
        }
        try {
            DAOFactory.getDAOFactory().getRigaRDADAO().save(rigaRDA);
        } catch (PersistentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }


}
