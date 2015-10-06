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
	public Pezzo() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_PEZZO_RIGARDA) {
			return ORM_rigaRDA;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Date dataArrivo;
	
	private int quantita;
	
	private com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo;
	
	private java.util.Set ORM_rigaRDA = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDataArrivo(java.util.Date value) {
		this.dataArrivo = value;
	}
	
	public java.util.Date getDataArrivo() {
		return dataArrivo;
	}
	
	public void setQuantita(int value) {
		this.quantita = value;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setDescrizionePezzo(com.coedil99.modello_di_dominio.DescrizionePezzo value) {
		this.descrizionePezzo = value;
	}
	
	public com.coedil99.modello_di_dominio.DescrizionePezzo getDescrizionePezzo() {
		return descrizionePezzo;
	}
	
	private void setORM_RigaRDA(java.util.Set value) {
		this.ORM_rigaRDA = value;
	}
	
	private java.util.Set getORM_RigaRDA() {
		return ORM_rigaRDA;
	}
	
	public final com.coedil99.modello_di_dominio.RigaRDASetCollection rigaRDA = new com.coedil99.modello_di_dominio.RigaRDASetCollection(this, _ormAdapter, com.coedil99.modello_di_dominio.ORMConstants.KEY_PEZZO_RIGARDA, com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGARDA_PEZZO, com.coedil99.modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
