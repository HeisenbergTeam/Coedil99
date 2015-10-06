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
	public Ordine() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_ORDINE_COMMESSE) {
			return ORM_commesse;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Date dataCreazione;
	
	private com.coedil99.modello_di_dominio.Destinazione destinazione;
	
	private java.util.Set ORM_commesse = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDataCreazione(java.util.Date value) {
		this.dataCreazione = value;
	}
	
	public java.util.Date getDataCreazione() {
		return dataCreazione;
	}
	
	public void setDestinazione(com.coedil99.modello_di_dominio.Destinazione value) {
		if (this.destinazione != value) {
			com.coedil99.modello_di_dominio.Destinazione ldestinazione = this.destinazione;
			this.destinazione = value;
			if (value != null) {
				destinazione.setOrdine(this);
			}
			if (ldestinazione != null && ldestinazione.getOrdine() == this) {
				ldestinazione.setOrdine(null);
			}
		}
	}
	
	public com.coedil99.modello_di_dominio.Destinazione getDestinazione() {
		return destinazione;
	}
	
	private void setORM_Commesse(java.util.Set value) {
		this.ORM_commesse = value;
	}
	
	private java.util.Set getORM_Commesse() {
		return ORM_commesse;
	}
	
	public final com.coedil99.modello_di_dominio.CommessaSetCollection commesse = new com.coedil99.modello_di_dominio.CommessaSetCollection(this, _ormAdapter, com.coedil99.modello_di_dominio.ORMConstants.KEY_ORDINE_COMMESSE, com.coedil99.modello_di_dominio.ORMConstants.KEY_COMMESSA_ORDINE, com.coedil99.modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
