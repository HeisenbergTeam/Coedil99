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

import java.util.Date;

public class Commessa {
	public Commessa() {
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_COMMESSA_ORDINE) {
			this.ordine = (Ordine) owner;
		}

		else if (key == ORMConstants.KEY_COMMESSA_DISTINTA) {
			this.distinta = (Distinta) owner;
		}
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};

	private int ID;

	private int priorita;

	private Ordine ordine;

	private Date dataCreazione;

	private Distinta distinta;

	private void setID(int value) {
		this.ID = value;
	}

	public int getID() {
		return ID;
	}

	public int getORMID() {
		return getID();
	}

	public void setPriorita(int value) {
		this.priorita = value;
	}

	public int getPriorita() {
		return priorita;
	}

	public void setDataCreazione(Date value) {
		this.dataCreazione = value;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setOrdine(Ordine value) {
		if (ordine != null) {
			ordine.commesse.remove(this);
		}
		if (value != null) {
			value.commesse.add(this);
		}
	}

	public Ordine getOrdine() {
		return ordine;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Ordine(Ordine value) {
		this.ordine = value;
	}

	private Ordine getORM_Ordine() {
		return ordine;
	}

	public void setDistinta(Distinta value) {
		if (this.distinta != value) {
			Distinta ldistinta = this.distinta;
			this.distinta = value;
			if (value != null) {
				distinta.setCommessa(this);
			} else {
				ldistinta.setCommessa(null);
			}
		}
	}

	public Distinta getDistinta() {
		return distinta;
	}

	public Distinta creaDistinta() {
		Distinta d = DAOFactory.getDAOFactory().getDistintaDAO()
				.createDistinta();
		this.distinta = d;
		return d;
	}

	public String toString() {
		return String.valueOf(getID());
	}

}
