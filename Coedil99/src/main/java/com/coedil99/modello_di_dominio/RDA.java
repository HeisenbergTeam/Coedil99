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

public class RDA {
	public RDA() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RDA_RIGHERDA) {
			return ORM_righeRDA;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RDA_FORNITORE) {
			this.fornitore = (com.coedil99.modello_di_dominio.Fornitore) owner;
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
	
	private com.coedil99.modello_di_dominio.Fornitore fornitore;
	
	private String descrizione;
	
	private java.util.Date dataCreazione;
	
	private java.util.Date dataArrivoPrevista;
	
	private java.util.Date dataArrivoEffettiva;
	
	private java.util.Set ORM_righeRDA = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
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
	
	public void setDataCreazione(java.util.Date value) {
		this.dataCreazione = value;
	}
	
	public java.util.Date getDataCreazione() {
		return dataCreazione;
	}
	
	public void setDataArrivoPrevista(java.util.Date value) {
		this.dataArrivoPrevista = value;
	}
	
	public java.util.Date getDataArrivoPrevista() {
		return dataArrivoPrevista;
	}
	
	public void setDataArrivoEffettiva(java.util.Date value) {
		this.dataArrivoEffettiva = value;
	}
	
	public java.util.Date getDataArrivoEffettiva() {
		return dataArrivoEffettiva;
	}
	
	public void setFornitore(com.coedil99.modello_di_dominio.Fornitore value) {
		if (fornitore != null) {
			fornitore.rda.remove(this);
		}
		if (value != null) {
			value.rda.add(this);
		}
	}
	
	public com.coedil99.modello_di_dominio.Fornitore getFornitore() {
		return fornitore;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Fornitore(com.coedil99.modello_di_dominio.Fornitore value) {
		this.fornitore = value;
	}
	
	private com.coedil99.modello_di_dominio.Fornitore getORM_Fornitore() {
		return fornitore;
	}
	
	private void setORM_RigheRDA(java.util.Set value) {
		this.ORM_righeRDA = value;
	}
	
	private java.util.Set getORM_RigheRDA() {
		return ORM_righeRDA;
	}
	
	public final com.coedil99.modello_di_dominio.RigaRDASetCollection righeRDA = new com.coedil99.modello_di_dominio.RigaRDASetCollection(this, _ormAdapter, com.coedil99.modello_di_dominio.ORMConstants.KEY_RDA_RIGHERDA, com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGARDA_RDA, com.coedil99.modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
