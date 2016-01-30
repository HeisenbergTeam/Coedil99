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
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class DescrizionePezzo {
	public DescrizionePezzo() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_DESCRIZIONEPEZZO_LAVORAZIONEPEZZO) {
			return ORM_lavorazionePezzo;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_DESCRIZIONEPEZZO_FORNITORE) {
			this.fornitore = (Fornitore) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};


	private int ID;
	
	private Fornitore fornitore;
	
	private String nome;
	
	private float diametro;
	
	private float peso;
	
	private java.util.Set ORM_lavorazionePezzo = new java.util.HashSet();
	
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
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDiametro(float value) {
		this.diametro = value;
	}
	
	public float getDiametro() {
		return diametro;
	}
	
	public void setPeso(float value) {
		this.peso = value;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setFornitore(Fornitore value) {
		if (fornitore != null) {
			fornitore.descrizionePezzo.remove(this);
		}
		if (value != null) {
			value.descrizionePezzo.add(this);
		}
	}
	@XmlIDREF
	public Fornitore getFornitore() {
		return fornitore;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Fornitore(Fornitore value) {
		this.fornitore = value;
	}

	@XmlTransient
	private Fornitore getORM_Fornitore() {
		return fornitore;
	}
	
	private void setORM_LavorazionePezzo(java.util.Set value) {
		this.ORM_lavorazionePezzo = value;
	}
	@XmlTransient
	private java.util.Set getORM_LavorazionePezzo() {
		return ORM_lavorazionePezzo;
	}
	@XmlTransient
	public final com.coedil99.modello_di_dominio.LavorazionePezzoSetCollection lavorazionePezzo = new com.coedil99.modello_di_dominio.LavorazionePezzoSetCollection(this, _ormAdapter, ORMConstants.KEY_DESCRIZIONEPEZZO_LAVORAZIONEPEZZO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
