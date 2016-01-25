package com.coedil99.controller.util;

import com.coedil99.modello_di_dominio.DAOFactory;
import com.coedil99.modello_di_dominio.RDA;
import com.coedil99.modello_di_dominio.RigaDistinta;
import com.coedil99.modello_di_dominio.RigaRDA;
import org.orm.PersistentException;

import java.util.Date;

/**
 * Created by me on 1/24/2016.
 */
public class UtilitaController {

    public static int GetQuantitaDisponibiliPezzo(int pezzoID) {
        Date dateNow = new Date();
        int quantitaOrdinate = 0;
        int quantitaArrivate = 0;
        int quantitaUtilizzate = 0;
        int quantitaDisponibili = 0;
        try {
            RigaRDA[] arrayRigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery("PezzoID = "+pezzoID, null);
            for (int i = 0; i < arrayRigaRDA.length; i++) {
                quantitaOrdinate = quantitaOrdinate + arrayRigaRDA[i].getPezzo().getQuantitaOrdinate();

                RDA rdaQuantita = arrayRigaRDA[i].getRda();
                if (rdaQuantita.getDataArrivoEffettiva().compareTo(dateNow) <= 0) {
                    quantitaArrivate = quantitaArrivate + arrayRigaRDA[i].getPezzo().getQuantitaOrdinate();
                }
            }

            RigaDistinta[] arrayRigaDistinta = DAOFactory.getDAOFactory().getRigaDistintaDAO().listRigaDistintaByQuery("PezzoID = "+pezzoID, null);
            for (int i = 0; i < arrayRigaDistinta.length; i++) {
                quantitaUtilizzate = quantitaUtilizzate + arrayRigaDistinta[i].getQuantitaRigaDistinta();
            }

            quantitaDisponibili = quantitaArrivate - quantitaUtilizzate;

            System.out.print("Quantità ordinate: " + quantitaOrdinate + " - Quantità arrivate: " + quantitaArrivate + " - Quantità utilizzate: " + quantitaUtilizzate + " - Quantità disponibili: " + quantitaDisponibili);

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return quantitaDisponibili;
    }
}
