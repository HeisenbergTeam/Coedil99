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

public class Sagoma {
	public Sagoma() {
	}
	
	private int ID;
	
	private String img;
	
	private com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setImg(String value) {
		this.img = value;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setLavorazionePezzo(com.coedil99.modello_di_dominio.LavorazionePezzo value) {
		if (this.lavorazionePezzo != value) {
			com.coedil99.modello_di_dominio.LavorazionePezzo llavorazionePezzo = this.lavorazionePezzo;
			this.lavorazionePezzo = value;
			if (value != null) {
				lavorazionePezzo.setSagoma(this);
			}
			if (llavorazionePezzo != null && llavorazionePezzo.getSagoma() == this) {
				llavorazionePezzo.setSagoma(null);
			}
		}
	}
	
	public com.coedil99.modello_di_dominio.LavorazionePezzo getLavorazionePezzo() {
		return lavorazionePezzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
