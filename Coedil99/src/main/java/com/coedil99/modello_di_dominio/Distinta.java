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

public class Distinta {
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };
    public final RigaDistintaSetCollection righeDistinta = new RigaDistintaSetCollection(this, _ormAdapter, ORMConstants.KEY_DISTINTA_RIGHEDISTINTA, ORMConstants.KEY_RIGADISTINTA_DISTINTA, ORMConstants.KEY_MUL_ONE_TO_MANY);
    private int ID;
    private java.util.Date dataInizio;
    private Commessa commessa;
    private int revisione;
    private String modello;
    private String elementoStrutturale;
    private java.util.Set ORM_righeDistinta = new java.util.HashSet();

    public Distinta() {
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_DISTINTA_RIGHEDISTINTA) {
            return ORM_righeDistinta;
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

    public java.util.Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(java.util.Date value) {
        this.dataInizio = value;
    }

    public int getRevisione() {
        return revisione;
    }

    public void setRevisione(int value) {
        this.revisione = value;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String value) {
        this.modello = value;
    }

    public String getElementoStrutturale() {
        return elementoStrutturale;
    }

    public void setElementoStrutturale(String value) {
        this.elementoStrutturale = value;
    }

    public Commessa getCommessa() {
        return commessa;
    }

    public void setCommessa(Commessa value) {
        if (this.commessa != value) {
            Commessa lcommessa = this.commessa;
            this.commessa = value;
            if (value != null) {
                commessa.setDistinta(this);
            }
            if (lcommessa != null && lcommessa.getDistinta() == this) {
                lcommessa.setDistinta(null);
            }
        }
    }

    private java.util.Set getORM_RigheDistinta() {
        return ORM_righeDistinta;
    }

    private void setORM_RigheDistinta(java.util.Set value) {
        this.ORM_righeDistinta = value;
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
