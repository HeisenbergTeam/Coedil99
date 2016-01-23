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
	
	private int ID;
	
	private int quantitaOrdinate;
	
	private com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo;
	
	private com.coedil99.modello_di_dominio.RigaRDA rigaRDA;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setQuantitaOrdinate(int value) {
		this.quantitaOrdinate = value;
	}
	
	public int getQuantitaOrdinate() {
		return quantitaOrdinate;
	}
	
	public void setDescrizionePezzo(com.coedil99.modello_di_dominio.DescrizionePezzo value) {
		this.descrizionePezzo = value;
	}
	
	public com.coedil99.modello_di_dominio.DescrizionePezzo getDescrizionePezzo() {
		return descrizionePezzo;
	}
	
	public void setRigaRDA(com.coedil99.modello_di_dominio.RigaRDA value) {
		if (this.rigaRDA != value) {
			com.coedil99.modello_di_dominio.RigaRDA lrigaRDA = this.rigaRDA;
			this.rigaRDA = value;
			if (value != null) {
				rigaRDA.setPezzo(this);
			}
			if (lrigaRDA != null && lrigaRDA.getPezzo() == this) {
				lrigaRDA.setPezzo(null);
			}
		}
	}
	
	public com.coedil99.modello_di_dominio.RigaRDA getRigaRDA() {
		return rigaRDA;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
