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

public class RigaRDA {
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public void setOwner(Object owner, int key) {
            this_setOwner(owner, key);
        }

    };
    private int ID;
    private Pezzo pezzo;
    private RDA rda;
    private String indicazione;

    public RigaRDA() {
    }

    private void this_setOwner(Object owner, int key) {
        if (key == ORMConstants.KEY_RIGARDA_RDA) {
            this.rda = (RDA) owner;
        } else if (key == ORMConstants.KEY_RIGARDA_PEZZO) {
            this.pezzo = (Pezzo) owner;
        }
    }

    public int getID() {
        return ID;
    }

    private void setID(int value) {
        this.ID = value;
    }

    public int getORMID() {
        return getID();
    }

    public String getIndicazione() {
        return indicazione;
    }

    public void setIndicazione(String value) {
        this.indicazione = value;
    }

    public RDA getRda() {
        return rda;
    }

    public void setRda(RDA value) {
        if (rda != null) {
            rda.righeRDA.remove(this);
        }
        if (value != null) {
            value.righeRDA.add(this);
        }
    }

    private RDA getORM_Rda() {
        return rda;
    }

    /**
     * This method is for internal use only.
     */
    public void setORM_Rda(RDA value) {
        this.rda = value;
    }

    public Pezzo getPezzo() {
        return pezzo;
    }

    public void setPezzo(Pezzo value) {
        if (pezzo != null) {
            pezzo.rigaRDA.remove(this);
        }
        if (value != null) {
            value.rigaRDA.add(this);
        }
    }

    private Pezzo getORM_Pezzo() {
        return pezzo;
    }

    /**
     * This method is for internal use only.
     */
    public void setORM_Pezzo(Pezzo value) {
        this.pezzo = value;
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
