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

public class Commessa {
	public Commessa() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_COMMESSA_ORDINE) {
			this.ordine = (modello_di_dominio.Ordine) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_COMMESSA_DISTINTA) {
			this.distinta = (modello_di_dominio.Distinta) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private Integer Priorita;
	
	private modello_di_dominio.Ordine ordine;
	
	private Date dataCreazione;
	
	private modello_di_dominio.Distinta distinta;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setPriorita(Integer value) {
		this.Priorita = value;
	}
	
	public Integer getPriorita() {
		return Priorita;
	}
	
	public void setDataCreazione(Date value) {
		this.dataCreazione = value;
	}
	
	public Date getDataCreazione() {
		return dataCreazione;
	}
	
	public void setOrdine(modello_di_dominio.Ordine value) {
		if (ordine != null) {
			ordine.commesse.remove(this);
		}
		if (value != null) {
			value.commesse.add(this);
		}
	}
	
	public modello_di_dominio.Ordine getOrdine() {
		return ordine;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Ordine(modello_di_dominio.Ordine value) {
		this.ordine = value;
	}
	
	private modello_di_dominio.Ordine getORM_Ordine() {
		return ordine;
	}
	
	public void setDistinta(modello_di_dominio.Distinta value) {
		if (this.distinta != value) {
			modello_di_dominio.Distinta ldistinta = this.distinta;
			this.distinta = value;
			if (value != null) {
				distinta.setCommessa(this);
			}
			else {
				ldistinta.setCommessa(null);
			}
		}
	}
	
	public modello_di_dominio.Distinta getDistinta() {
		return distinta;
	}
	
	public modello_di_dominio.Distinta creaDistinta() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
