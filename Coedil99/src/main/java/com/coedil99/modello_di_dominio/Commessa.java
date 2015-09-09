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

public class Commessa {
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public void setOwner(Object owner, int key) {
            this_setOwner(owner, key);
        }

    };
    private int ID;
    private Integer priorita;
    private Ordine ordine;
    private java.util.Date dataCreazione;
    private Distinta distinta;

    public Commessa() {
    }

    private void this_setOwner(Object owner, int key) {
        if (key == ORMConstants.KEY_COMMESSA_ORDINE) {
            this.ordine = (Ordine) owner;
        } else if (key == ORMConstants.KEY_COMMESSA_DISTINTA) {
            this.distinta = (Distinta) owner;
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

    public Integer getPriorita() {
        return priorita;
    }

    public void setPriorita(Integer value) {
        this.priorita = value;
    }

    public java.util.Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(java.util.Date value) {
        this.dataCreazione = value;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine value) {
        if (ordine != null) {
            ordine.commesse.remove(this);
        }
        if (value != null) {
            value.commesse.add(this);
        }
    }

    private Ordine getORM_Ordine() {
        return ordine;
    }

    /**
     * This method is for internal use only.
     */
    public void setORM_Ordine(Ordine value) {
        this.ordine = value;
    }

    public Distinta getDistinta() {
        return distinta;
    }

    public void setDistinta(Distinta value) {
        if (this.distinta != value) {
            Distinta ldistinta = this.distinta;
            this.distinta = value;
            if (value != null) {
                distinta.setCommessa(this);
            }
            if (ldistinta != null && ldistinta.getCommessa() == this) {
                ldistinta.setCommessa(null);
            }
        }
    }

    public Distinta creaDistinta() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
