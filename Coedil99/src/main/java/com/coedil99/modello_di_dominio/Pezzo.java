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

public class Pezzo {
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };
    public final RigaRDASetCollection rigaRDA = new RigaRDASetCollection(this, _ormAdapter, ORMConstants.KEY_PEZZO_RIGARDA, ORMConstants.KEY_RIGARDA_PEZZO, ORMConstants.KEY_MUL_ONE_TO_MANY);
    private int ID;
    private java.util.Date dataArrivo;
    private int quantita;
    private DescrizionePezzo descrizionePezzo;
    private java.util.Set ORM_rigaRDA = new java.util.HashSet();

    public Pezzo() {
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_PEZZO_RIGARDA) {
            return ORM_rigaRDA;
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

    public java.util.Date getDataArrivo() {
        return dataArrivo;
    }

    public void setDataArrivo(java.util.Date value) {
        this.dataArrivo = value;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int value) {
        this.quantita = value;
    }

    public DescrizionePezzo getDescrizionePezzo() {
        return descrizionePezzo;
    }

    public void setDescrizionePezzo(DescrizionePezzo value) {
        this.descrizionePezzo = value;
    }

    private java.util.Set getORM_RigaRDA() {
        return ORM_rigaRDA;
    }

    private void setORM_RigaRDA(java.util.Set value) {
        this.ORM_rigaRDA = value;
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
