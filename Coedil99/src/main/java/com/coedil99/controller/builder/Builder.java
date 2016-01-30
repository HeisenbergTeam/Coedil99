package com.coedil99.controller.builder;

import com.coedil99.modello_di_dominio.*;
import org.orm.PersistentException;

import java.util.Date;

/**
 * Created by me on 1/25/2016.
 */
public class Builder {

    /*
 * USAGE
 * Fornitore fornitore = new Builder.FornitoreBuilder().setNome("ItalTubi").build();
 */
    public static class FornitoreBuilder
    {
        private Fornitore fornitore = DAOFactory.getDAOFactory().getFornitoreDAO().createFornitore();
        public FornitoreBuilder setNome(String strNomeFornitore) {this.fornitore.setNome(strNomeFornitore); return this;}
        public Fornitore build() {
            try {
                DAOFactory.getDAOFactory().getFornitoreDAO().save(this.fornitore);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.fornitore;
        }
    }

    /*
     * USAGE
     * DescrizionePezzo descrizionePezzo = new DescrizionePezzoBuilder()
     *  .setNome("Tubo acciaio inox")
     *  .setPeso(1.4f)
     *  .setDiametro(0.020f)
     *  .setFornitore(fornitore)
     *  .build();
     */
    public static class DescrizionePezzoBuilder
    {
        private DescrizionePezzo descrizionePezzo = DAOFactory.getDAOFactory().getDescrizionePezzoDAO().createDescrizionePezzo();
        public DescrizionePezzoBuilder setNome(String strNomePezzo) {this.descrizionePezzo.setNome(strNomePezzo); return this;}
        public DescrizionePezzoBuilder setPeso(float floatPeso) {this.descrizionePezzo.setPeso(floatPeso); return this;}
        public DescrizionePezzoBuilder setDiametro(float floatDiametro)  {this.descrizionePezzo.setDiametro(floatDiametro); return this;}
        public DescrizionePezzoBuilder setFornitore(Fornitore fornitore)  {this.descrizionePezzo.setFornitore(fornitore); return this;}
        public DescrizionePezzo build() {
            try {
                DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(this.descrizionePezzo);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return this.descrizionePezzo;
        }
    }

    public static class CommessaBuilder
    {
        private Commessa commessa = DAOFactory.getDAOFactory().getCommessaDAO().createCommessa();
        public CommessaBuilder setOrdine(Ordine ordine) {this.commessa.setOrdine(ordine); return this;}
        public CommessaBuilder setPriorita(int priorita) {this.commessa.setPriorita(priorita); return this;}
        public CommessaBuilder setDataCreazione(Date dataCreazione) {this.commessa.setDataCreazione(dataCreazione); return this;}
        public Commessa build() {
            try {
                DAOFactory.getDAOFactory().getCommessaDAO().save(commessa);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.commessa;
        }
    }

    public static class DistintaBuilder
    {
        private Distinta distinta = DAOFactory.getDAOFactory().getDistintaDAO().createDistinta();
        public DistintaBuilder setDataInizio(Date dataInizio) {this.distinta.setDataInizio(dataInizio); return this;}
        public DistintaBuilder setCommessa(Commessa commessa) {this.distinta.setCommessa(commessa); return this;}
        public DistintaBuilder setModello(String modello) {this.distinta.setModello(modello); return this;}
        public DistintaBuilder setRevisione(int revisione) {this.distinta.setRevisione(revisione); return this;}
        public DistintaBuilder setElementoStrutturale(String elementoStrutturale) {this.distinta.setElementoStrutturale(elementoStrutturale); return this;}
        public Distinta build() {
            try {
                DAOFactory.getDAOFactory().getDistintaDAO().save(distinta);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.distinta;
        }
    }

    public static class RigaDistintaBuilder
    {
        private RigaDistinta rigaDistinta = DAOFactory.getDAOFactory().getRigaDistintaDAO().createRigaDistinta();
        public RigaDistintaBuilder setDistinta(Distinta distinta) {this.rigaDistinta.setDistinta(distinta); return this;}
        public RigaDistintaBuilder setIndicazione(String indicazione) {this.rigaDistinta.setIndicazione(indicazione); return this;}
        public RigaDistintaBuilder setPezzo(Pezzo pezzo) {this.rigaDistinta.setPezzo(pezzo); return this;}
        public RigaDistintaBuilder setLavorazionePezzo(LavorazionePezzo lavorazionePezzo) {this.rigaDistinta.setLavorazionePezzo(lavorazionePezzo); return this;}
        public RigaDistintaBuilder setQuantitaRigaDistinta(int quantitaRigaDistinta) {this.rigaDistinta.setQuantitaRigaDistinta(quantitaRigaDistinta); return this;}
        public RigaDistinta build() {
            try {
                DAOFactory.getDAOFactory().getRigaDistintaDAO().save(rigaDistinta);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.rigaDistinta;
        }
    }


    public static class DestinazioneBuilder
    {
        private Destinazione destinazione = DAOFactory.getDAOFactory().getDestinazioneDAO().createDestinazione();
        public DestinazioneBuilder setVia(String via) {this.destinazione.setVia(via); return this;}
        public Destinazione build() {
            try {
                DAOFactory.getDAOFactory().getDestinazioneDAO().save(this.destinazione);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.destinazione;
        }
    }

    public static class OrdineBuilder
    {
        private Ordine ordine = DAOFactory.getDAOFactory().getOrdineDAO().createOrdine();
        public OrdineBuilder setDataCreazione(Date dataCreazione) {this.ordine.setDataCreazione(dataCreazione); return this;}
        public OrdineBuilder setDestinazione(Destinazione destinazione) {this.ordine.setDestinazione(destinazione); return this;}
        public Ordine build() {
            try {
                DAOFactory.getDAOFactory().getOrdineDAO().save(this.ordine);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.ordine;
        }
    }


    public static class PezzoBuilder
    {
        private Pezzo pezzo = DAOFactory.getDAOFactory().getPezzoDAO().createPezzo();
        public PezzoBuilder setDescrizionePezzo(DescrizionePezzo descrizionePezzo) {this.pezzo.setDescrizionePezzo(descrizionePezzo); return this;}
        public PezzoBuilder setQuantitaOrdinate(int quantitaOrdinate) {this.pezzo.setQuantitaOrdinate(quantitaOrdinate); return this;}
        public Pezzo build() {
            try {
                DAOFactory.getDAOFactory().getPezzoDAO().save(pezzo);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.pezzo;
        }
    }

    public static class RDABuilder
    {
        private RDA rda = DAOFactory.getDAOFactory().getRDADAO().createRDA();
        public RDABuilder setFornitore(Fornitore fornitore) {this.rda.setFornitore(fornitore); return this;}
        public RDABuilder setDescrizione(String descrizione) {this.rda.setDescrizione(descrizione); return this;}
        public RDABuilder setDataArrivoEffettiva(Date dataArrivoEffettiva) {this.rda.setDataArrivoEffettiva(dataArrivoEffettiva); return this;}
        public RDABuilder setDataArrivoPrevista(Date dataArrivoPrevista) {this.rda.setDataArrivoPrevista(dataArrivoPrevista); return this;}
        public RDABuilder setDataCreazione(Date dataCreazione) {this.rda.setDataCreazione(dataCreazione); return this;}
        public RDA build() {
            try {
                DAOFactory.getDAOFactory().getRDADAO().save(rda);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.rda;
        }
    }

    public static class RigaRDABuilder
    {
        private RigaRDA rigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().createRigaRDA();
        public RigaRDABuilder setIndicazione(String indicazione) {this.rigaRDA.setIndicazione(indicazione); return this;}
        public RigaRDABuilder setPezzo(Pezzo pezzo) {this.rigaRDA.setPezzo(pezzo); return this;}
        public RigaRDABuilder setRda(RDA rda) {this.rigaRDA.setRda(rda); return this;}
        public RigaRDA build() {
            try {
                DAOFactory.getDAOFactory().getRigaRDADAO().save(rigaRDA);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            return this.rigaRDA;
        }
    }

}
