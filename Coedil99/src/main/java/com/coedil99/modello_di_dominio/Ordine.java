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

public class Ordine {
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };
    public final CommessaSetCollection commesse = new CommessaSetCollection(this, _ormAdapter, ORMConstants.KEY_ORDINE_COMMESSE, ORMConstants.KEY_COMMESSA_ORDINE, ORMConstants.KEY_MUL_ONE_TO_MANY);
    private int ID;
    private java.util.Date dataCreazione;
    private Destinazione destinazione;
    private java.util.Set ORM_commesse = new java.util.HashSet();

    public Ordine() {
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_ORDINE_COMMESSE) {
            return ORM_commesse;
        }

        return null;
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

    public java.util.Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(java.util.Date value) {
        this.dataCreazione = value;
    }

    public Destinazione getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(Destinazione value) {
        if (this.destinazione != value) {
            Destinazione ldestinazione = this.destinazione;
            this.destinazione = value;
            if (value != null) {
                destinazione.setOrdine(this);
            }
            if (ldestinazione != null && ldestinazione.getOrdine() == this) {
                ldestinazione.setOrdine(null);
            }
        }
    }

    private java.util.Set getORM_Commesse() {
        return ORM_commesse;
    }

    private void setORM_Commesse(java.util.Set value) {
        this.ORM_commesse = value;
    }

    public Commessa creaCommessa() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
