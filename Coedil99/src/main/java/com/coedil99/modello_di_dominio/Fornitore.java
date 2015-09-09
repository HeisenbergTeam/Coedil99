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

public class Fornitore {
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };
    public final RDASetCollection rda = new RDASetCollection(this, _ormAdapter, ORMConstants.KEY_FORNITORE_RDA, ORMConstants.KEY_RDA_FORNITORE, ORMConstants.KEY_MUL_ONE_TO_MANY);
    public final DescrizionePezzoSetCollection descrizionePezzo = new DescrizionePezzoSetCollection(this, _ormAdapter, ORMConstants.KEY_FORNITORE_DESCRIZIONEPEZZO, ORMConstants.KEY_DESCRIZIONEPEZZO_FORNITORE, ORMConstants.KEY_MUL_ONE_TO_MANY);
    private int ID;

    private String nome;

    private java.util.Set ORM_rda = new java.util.HashSet();

    private java.util.Set ORM_descrizionePezzo = new java.util.HashSet();

    public Fornitore() {
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_FORNITORE_RDA) {
            return ORM_rda;
        } else if (key == ORMConstants.KEY_FORNITORE_DESCRIZIONEPEZZO) {
            return ORM_descrizionePezzo;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }

    private java.util.Set getORM_Rda() {
        return ORM_rda;
    }

    private void setORM_Rda(java.util.Set value) {
        this.ORM_rda = value;
    }

    private java.util.Set getORM_DescrizionePezzo() {
        return ORM_descrizionePezzo;
    }

    private void setORM_DescrizionePezzo(java.util.Set value) {
        this.ORM_descrizionePezzo = value;
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
