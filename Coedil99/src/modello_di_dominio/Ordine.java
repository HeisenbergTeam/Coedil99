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

public class Ordine {
	public Ordine() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_ORDINE_COMMESSE) {
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

	private java.util.Set ORM_commesse = new java.util.HashSet();

	public final modello_di_dominio.CommessaSetCollection commesse = new modello_di_dominio.CommessaSetCollection(
			this, _ormAdapter,
			modello_di_dominio.ORMConstants.KEY_ORDINE_COMMESSE,
			modello_di_dominio.ORMConstants.KEY_COMMESSA_ORDINE,
			modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);

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

	private void setORM_Commesse(java.util.Set value) {
		this.ORM_commesse = value;
	}

	private java.util.Set getORM_Commesse() {
		return ORM_commesse;
	}

	public modello_di_dominio.Commessa creaCommessa() {
		// TODO: Implement Method
		this.commesse.add(DAOFactory.getDAOFactory().getCommessaDAO()
				.createCommessa());
		return this.commesse.toArray()[commesse.size()-1];
	}

	public CommessaSetCollection getCommesse() {
		return this.commesse;
	}

	public String toString() {
		return String.valueOf(getID());
	}

}
