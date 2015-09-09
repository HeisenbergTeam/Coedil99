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

public class RDA {
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

        public void setOwner(Object owner, int key) {
            this_setOwner(owner, key);
        }

    };
    public final RigaRDASetCollection righeRDA = new RigaRDASetCollection(this, _ormAdapter, ORMConstants.KEY_RDA_RIGHERDA, ORMConstants.KEY_RIGARDA_RDA, ORMConstants.KEY_MUL_ONE_TO_MANY);
    private int ID;
    private Fornitore fornitore;
    private String descrizione;
    private java.util.Date dataCreazione;
    private java.util.Set ORM_righeRDA = new java.util.HashSet();

    public RDA() {
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_RDA_RIGHERDA) {
            return ORM_righeRDA;
        }

        return null;
    }

    private void this_setOwner(Object owner, int key) {
        if (key == ORMConstants.KEY_RDA_FORNITORE) {
            this.fornitore = (Fornitore) owner;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String value) {
        this.descrizione = value;
    }

    public java.util.Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(java.util.Date value) {
        this.dataCreazione = value;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public void setFornitore(Fornitore value) {
        if (fornitore != null) {
            fornitore.rda.remove(this);
        }
        if (value != null) {
            value.rda.add(this);
        }
    }

    private Fornitore getORM_Fornitore() {
        return fornitore;
    }

    /**
     * This method is for internal use only.
     */
    public void setORM_Fornitore(Fornitore value) {
        this.fornitore = value;
    }

    private java.util.Set getORM_RigheRDA() {
        return ORM_righeRDA;
    }

    private void setORM_RigheRDA(java.util.Set value) {
        this.ORM_righeRDA = value;
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
