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

public class Distinta {
	public Distinta() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_DISTINTA_RIGHEDISTINTA) {
			return ORM_righeDistinta;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Date dataInizio;
	
	private com.coedil99.modello_di_dominio.Commessa commessa;
	
	private int revisione;
	
	private String modello;
	
	private String elementoStrutturale;
	
	private java.util.Set ORM_righeDistinta = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDataInizio(java.util.Date value) {
		this.dataInizio = value;
	}
	
	public java.util.Date getDataInizio() {
		return dataInizio;
	}
	
	public void setRevisione(int value) {
		this.revisione = value;
	}
	
	public int getRevisione() {
		return revisione;
	}
	
	public void setModello(String value) {
		this.modello = value;
	}
	
	public String getModello() {
		return modello;
	}
	
	public void setElementoStrutturale(String value) {
		this.elementoStrutturale = value;
	}
	
	public String getElementoStrutturale() {
		return elementoStrutturale;
	}
	
	public void setCommessa(com.coedil99.modello_di_dominio.Commessa value) {
		if (this.commessa != value) {
			com.coedil99.modello_di_dominio.Commessa lcommessa = this.commessa;
			this.commessa = value;
			if (value != null) {
				commessa.setDistinta(this);
			}
			if (lcommessa != null && lcommessa.getDistinta() == this) {
				lcommessa.setDistinta(null);
			}
		}
	}
	
	public com.coedil99.modello_di_dominio.Commessa getCommessa() {
		return commessa;
	}
	
	private void setORM_RigheDistinta(java.util.Set value) {
		this.ORM_righeDistinta = value;
	}
	
	private java.util.Set getORM_RigheDistinta() {
		return ORM_righeDistinta;
	}
	
	public final com.coedil99.modello_di_dominio.RigaDistintaSetCollection righeDistinta = new com.coedil99.modello_di_dominio.RigaDistintaSetCollection(this, _ormAdapter, com.coedil99.modello_di_dominio.ORMConstants.KEY_DISTINTA_RIGHEDISTINTA, com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_DISTINTA, com.coedil99.modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
