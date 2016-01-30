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

import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LavorazionePezzo {
	public LavorazionePezzo() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_LAVORAZIONEPEZZO_SAGOMA) {
			this.sagoma = (Sagoma) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private String descrizione;
	
	private float misuraDiTaglio;
	
	private float peso;
	
	private Sagoma sagoma;
	
	private void setID(int value) {
		this.ID = value;
	}
	@XmlID
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setMisuraDiTaglio(float value) {
		this.misuraDiTaglio = value;
	}
	
	public float getMisuraDiTaglio() {
		return misuraDiTaglio;
	}
	
	public void setPeso(float value) {
		this.peso = value;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setSagoma(Sagoma value) {
		if (this.sagoma != value) {
			Sagoma lsagoma = this.sagoma;
			this.sagoma = value;
			if (value != null) {
				sagoma.setLavorazionePezzo(this);
			}
			if (lsagoma != null && lsagoma.getLavorazionePezzo() == this) {
				lsagoma.setLavorazionePezzo(null);
			}
		}
	}
	@XmlIDREF
	public Sagoma getSagoma() {
		return sagoma;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
