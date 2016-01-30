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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Fornitore {
	public Fornitore() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_FORNITORE_RDA) {
			return ORM_rda;
		}
		else if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_FORNITORE_DESCRIZIONEPEZZO) {
			return ORM_descrizionePezzo;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private String nome;
	
	private java.util.Set ORM_rda = new java.util.HashSet();
	
	private java.util.Set ORM_descrizionePezzo = new java.util.HashSet();
	
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
	
	private void setORM_Rda(java.util.Set value) {
		this.ORM_rda = value;
	}
	@XmlTransient
	private java.util.Set getORM_Rda() {
		return ORM_rda;
	}
	@XmlTransient
	public final com.coedil99.modello_di_dominio.RDASetCollection rda = new com.coedil99.modello_di_dominio.RDASetCollection(this, _ormAdapter, com.coedil99.modello_di_dominio.ORMConstants.KEY_FORNITORE_RDA, com.coedil99.modello_di_dominio.ORMConstants.KEY_RDA_FORNITORE, com.coedil99.modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_DescrizionePezzo(java.util.Set value) {
		this.ORM_descrizionePezzo = value;
	}

	@XmlTransient
	private java.util.Set getORM_DescrizionePezzo() {
		return ORM_descrizionePezzo;
	}
	@XmlTransient
	public final com.coedil99.modello_di_dominio.DescrizionePezzoSetCollection descrizionePezzo = new com.coedil99.modello_di_dominio.DescrizionePezzoSetCollection(this, _ormAdapter, com.coedil99.modello_di_dominio.ORMConstants.KEY_FORNITORE_DESCRIZIONEPEZZO, com.coedil99.modello_di_dominio.ORMConstants.KEY_DESCRIZIONEPEZZO_FORNITORE, com.coedil99.modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
