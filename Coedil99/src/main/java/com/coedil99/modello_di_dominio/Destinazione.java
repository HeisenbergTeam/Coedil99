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

public class Destinazione {
	public Destinazione() {
	}
	
	private int ID;
	
	private String via;
	
	private com.coedil99.modello_di_dominio.Ordine ordine;
	
	public void setVia(String value) {
		this.via = value;
	}
	
	public String getVia() {
		return via;
	}
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setOrdine(com.coedil99.modello_di_dominio.Ordine value) {
		if (this.ordine != value) {
			com.coedil99.modello_di_dominio.Ordine lordine = this.ordine;
			this.ordine = value;
			if (value != null) {
				ordine.setDestinazione(this);
			}
			if (lordine != null && lordine.getDestinazione() == this) {
				lordine.setDestinazione(null);
			}
		}
	}
	
	public com.coedil99.modello_di_dominio.Ordine getOrdine() {
		return ordine;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
