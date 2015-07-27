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

public class Ordine {
	public Ordine() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == ORMConstants.KEY_ORDINE_COMMESSE) {
			return ORM_commesse;
		}

		return null;
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

	};

	private int ID;

	private Date dataCreazione;

	private Destinazione destinazione;

	private java.util.Set ORM_commesse = new java.util.HashSet();

	private void setID(int value) {
		this.ID = value;
	}

	public int getID() {
		return ID;
	}

	public int getORMID() {
		return getID();
	}

	public void setDataCreazione(Date value) {
		this.dataCreazione = value;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDestinazione(Destinazione value) {
		if (this.destinazione != value) {
			Destinazione ldestinazione = this.destinazione;
			this.destinazione = value;
			if (value != null) {
				destinazione.setOrdine(this);
			} else {
				ldestinazione.setOrdine(null);
			}
		}
	}

	public Destinazione getDestinazione() {
		return destinazione;
	}

	private void setORM_Commesse(java.util.Set value) {
		this.ORM_commesse = value;
	}

	private java.util.Set getORM_Commesse() {
		return ORM_commesse;
	}

	public final CommessaSetCollection commesse = new CommessaSetCollection(
			this, _ormAdapter,
			ORMConstants.KEY_ORDINE_COMMESSE,
			ORMConstants.KEY_COMMESSA_ORDINE,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	public Commessa creaCommessa() {
		// TODO: Implement Method

		Commessa c = DAOFactory.getDAOFactory().getCommessaDAO()
				.createCommessa();
		this.commesse.add(c);
		return c;
	}

	public String toString() {
		return String.valueOf(getID());
	}

}
