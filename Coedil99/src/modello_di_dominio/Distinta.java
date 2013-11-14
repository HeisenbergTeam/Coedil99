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
package modello_di_dominio;

import java.util.Date;

public class Distinta {
	public Distinta() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_DISTINTA_RIGHEDISTINTA) {
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
	
	private Date dataInizio;
	
	private modello_di_dominio.Commessa commessa;
	
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
	
	public void setDataInizio(Date value) {
		this.dataInizio = value;
	}
	
	public Date getDataInizio() {
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
	
	public void setCommessa(modello_di_dominio.Commessa value) {
		if (this.commessa != value) {
			modello_di_dominio.Commessa lcommessa = this.commessa;
			this.commessa = value;
			if (value != null) {
				commessa.setDistinta(this);
			}
			else {
				lcommessa.setDistinta(null);
			}
		}
	}
	
	public modello_di_dominio.Commessa getCommessa() {
		return commessa;
	}
	
	private void setORM_RigheDistinta(java.util.Set value) {
		this.ORM_righeDistinta = value;
	}
	
	private java.util.Set getORM_RigheDistinta() {
		return ORM_righeDistinta;
	}
	
	public final modello_di_dominio.RigaDistintaSetCollection righeDistinta = new modello_di_dominio.RigaDistintaSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_DISTINTA_RIGHEDISTINTA, modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_DISTINTA, modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
