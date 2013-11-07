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

import org.orm.PersistentException;

import modello_di_dominio.dao.RigaDistintaDAO;

public class Distinta {
	public Distinta() {
	}

	private java.util.Set this_getSet(int key) {
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

	private Date DataInizio;

	private modello_di_dominio.Commessa commessa;

	private java.util.Set ORM_righeDistinta = new java.util.HashSet();

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

	public void setDataInizio(Date value) {
		this.DataInizio = value;
	}

	public Date getDataInizio() {
		return DataInizio;
	}

	public void setCommessa(modello_di_dominio.Commessa value) {
		if (this.commessa != value) {
			modello_di_dominio.Commessa lcommessa = this.commessa;
			this.commessa = value;
			if (value != null) {
				commessa.setDistinta(this);
			} else {
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

	public final modello_di_dominio.RigaDistintaSetCollection righeDistinta = new modello_di_dominio.RigaDistintaSetCollection(
			this, _ormAdapter,
			modello_di_dominio.ORMConstants.KEY_DISTINTA_RIGHEDISTINTA,
			modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_DISTINTA,
			modello_di_dominio.ORMConstants.KEY_MUL_ONE_TO_MANY);

	public String toString() {
		return String.valueOf(getID());
	}

	public int creaRigaDistinta(Pezzo pezzo, LavorazionePezzo lavorazione) {
		RigaDistinta riga = new RigaDistinta();
		riga.setPezzo(pezzo);
		riga.setLavorazionePezzo(lavorazione);
		try {
			DAOFactory.getDAOFactory().getRigaDistintaDAO().save(riga);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return riga.getID();
	}

	public String getIndicazione() {
		return indicazione;
	}

	public void setIndicazione(String indicazione) {
		this.indicazione = indicazione;
	}

}
