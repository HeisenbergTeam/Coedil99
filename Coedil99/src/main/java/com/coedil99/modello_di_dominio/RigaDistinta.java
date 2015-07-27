/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Faculty of informatics, Burapha University 01
 * License Type: Purchased
 */
package com.coedil99.modello_di_dominio;

public class RigaDistinta {
	public RigaDistinta() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_RIGADISTINTA_PEZZO) {
			this.pezzo = (Pezzo) owner;
		}
		
		else if (key == ORMConstants.KEY_RIGADISTINTA_DISTINTA) {
			this.distinta = (Distinta) owner;
		}
		
		else if (key == ORMConstants.KEY_RIGADISTINTA_LAVORAZIONEPEZZO) {
			this.lavorazionePezzo = (LavorazionePezzo) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private Pezzo pezzo;
	
	private Distinta distinta;
	
	private LavorazionePezzo lavorazionePezzo;
	
	private String indicazione;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setIndicazione(String value) {
		this.indicazione = value;
	}
	
	public String getIndicazione() {
		return indicazione;
	}
	
	public void setPezzo(Pezzo value) {
		this.pezzo = value;
	}
	
	public Pezzo getPezzo() {
		return pezzo;
	}
	
	public void setDistinta(Distinta value) {
		if (distinta != null) {
			distinta.righeDistinta.remove(this);
		}
		if (value != null) {
			value.righeDistinta.add(this);
		}
	}
	
	public Distinta getDistinta() {
		return distinta;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Distinta(Distinta value) {
		this.distinta = value;
	}
	
	private Distinta getORM_Distinta() {
		return distinta;
	}
	
	public void setLavorazionePezzo(LavorazionePezzo value) {
		this.lavorazionePezzo = value;
	}
	
	public LavorazionePezzo getLavorazionePezzo() {
		return lavorazionePezzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
