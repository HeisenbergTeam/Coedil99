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

public class RigaDistinta {
	public RigaDistinta() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_PEZZO) {
			this.pezzo = (com.coedil99.modello_di_dominio.Pezzo) owner;
		}
		
		else if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_DISTINTA) {
			this.distinta = (com.coedil99.modello_di_dominio.Distinta) owner;
		}
		
		else if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_LAVORAZIONEPEZZO) {
			this.lavorazionePezzo = (com.coedil99.modello_di_dominio.LavorazionePezzo) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private com.coedil99.modello_di_dominio.Pezzo pezzo;
	
	private com.coedil99.modello_di_dominio.Distinta distinta;
	
	private com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo;
	
	private int quantitaRigaDistinta;
	
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
	
	public void setQuantitaRigaDistinta(int value) {
		this.quantitaRigaDistinta = value;
	}
	
	public int getQuantitaRigaDistinta() {
		return quantitaRigaDistinta;
	}
	
	public void setPezzo(com.coedil99.modello_di_dominio.Pezzo value) {
		this.pezzo = value;
	}
	
	public com.coedil99.modello_di_dominio.Pezzo getPezzo() {
		return pezzo;
	}
	
	public void setDistinta(com.coedil99.modello_di_dominio.Distinta value) {
		if (distinta != null) {
			distinta.righeDistinta.remove(this);
		}
		if (value != null) {
			value.righeDistinta.add(this);
		}
	}
	
	public com.coedil99.modello_di_dominio.Distinta getDistinta() {
		return distinta;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Distinta(com.coedil99.modello_di_dominio.Distinta value) {
		this.distinta = value;
	}
	
	private com.coedil99.modello_di_dominio.Distinta getORM_Distinta() {
		return distinta;
	}
	
	public void setLavorazionePezzo(com.coedil99.modello_di_dominio.LavorazionePezzo value) {
		this.lavorazionePezzo = value;
	}
	
	public com.coedil99.modello_di_dominio.LavorazionePezzo getLavorazionePezzo() {
		return lavorazionePezzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
