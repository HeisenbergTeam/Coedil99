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
	public Commessa() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_COMMESSA_ORDINE) {
			this.ordine = (com.coedil99.modello_di_dominio.Ordine) owner;
		}
		
		else if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_COMMESSA_DISTINTA) {
			this.distinta = (com.coedil99.modello_di_dominio.Distinta) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private int priorita;
	
	private com.coedil99.modello_di_dominio.Ordine ordine;
	
	private java.util.Date dataCreazione;
	
	private com.coedil99.modello_di_dominio.Distinta distinta;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setPriorita(int value) {
		this.priorita = value;
	}
	
	public int getPriorita() {
		return priorita;
	}
	
	public void setDataCreazione(java.util.Date value) {
		this.dataCreazione = value;
	}
	
	public java.util.Date getDataCreazione() {
		return dataCreazione;
	}
	
	public void setOrdine(com.coedil99.modello_di_dominio.Ordine value) {
		if (ordine != null) {
			ordine.commesse.remove(this);
		}
		if (value != null) {
			value.commesse.add(this);
		}
	}
	
	public com.coedil99.modello_di_dominio.Ordine getOrdine() {
		return ordine;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Ordine(com.coedil99.modello_di_dominio.Ordine value) {
		this.ordine = value;
	}
	
	private com.coedil99.modello_di_dominio.Ordine getORM_Ordine() {
		return ordine;
	}
	
	public void setDistinta(com.coedil99.modello_di_dominio.Distinta value) {
		if (this.distinta != value) {
			com.coedil99.modello_di_dominio.Distinta ldistinta = this.distinta;
			this.distinta = value;
			if (value != null) {
				distinta.setCommessa(this);
			}
			if (ldistinta != null && ldistinta.getCommessa() == this) {
				ldistinta.setCommessa(null);
			}
		}
	}
	
	public com.coedil99.modello_di_dominio.Distinta getDistinta() {
		return distinta;
	}
	
	public com.coedil99.modello_di_dominio.Distinta creaDistinta() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
