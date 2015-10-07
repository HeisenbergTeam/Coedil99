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

public class RigaRDA {
	public RigaRDA() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGARDA_RDA) {
			this.rda = (com.coedil99.modello_di_dominio.RDA) owner;
		}
		
		else if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGARDA_PEZZO) {
			this.pezzo = (com.coedil99.modello_di_dominio.Pezzo) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private com.coedil99.modello_di_dominio.Pezzo pezzo;
	
	private com.coedil99.modello_di_dominio.RDA rda;
	
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
	
	public void setRda(com.coedil99.modello_di_dominio.RDA value) {
		if (rda != null) {
			rda.righeRDA.remove(this);
		}
		if (value != null) {
			value.righeRDA.add(this);
		}
	}
	
	public com.coedil99.modello_di_dominio.RDA getRda() {
		return rda;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Rda(com.coedil99.modello_di_dominio.RDA value) {
		this.rda = value;
	}
	
	private com.coedil99.modello_di_dominio.RDA getORM_Rda() {
		return rda;
	}
	
	public void setPezzo(com.coedil99.modello_di_dominio.Pezzo value) {
		if (pezzo != null) {
			pezzo.rigaRDA.remove(this);
		}
		if (value != null) {
			value.rigaRDA.add(this);
		}
	}
	
	public com.coedil99.modello_di_dominio.Pezzo getPezzo() {
		return pezzo;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pezzo(com.coedil99.modello_di_dominio.Pezzo value) {
		this.pezzo = value;
	}
	
	private com.coedil99.modello_di_dominio.Pezzo getORM_Pezzo() {
		return pezzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}