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

import javax.xml.bind.annotation.*;

@XmlRootElement
public class RigaRDA {
	public RigaRDA() {
	}

	private void this_setOwner(Object owner, int key) {
		if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGARDA_RDA) {
			this.rda = (RDA) owner;
		}

		else if (key == com.coedil99.modello_di_dominio.ORMConstants.KEY_RIGARDA_PEZZO) {
			this.pezzo = (Pezzo) owner;
		}
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};


	private int ID;

	private Pezzo pezzo;

	private RDA rda;

	private String indicazione;

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

	public void setIndicazione(String value) {
		this.indicazione = value;
	}

	public String getIndicazione() {
		return indicazione;
	}

	public void setRda(RDA value) {
		if (rda != null) {
			rda.righeRDA.remove(this);
		}
		if (value != null) {
			value.righeRDA.add(this);
		}
	}
	@XmlTransient
	public RDA getRda() {
		return rda;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Rda(RDA value) {
		this.rda = value;
	}

	@XmlTransient
	private RDA getORM_Rda() {
		return rda;
	}

	public void setPezzo(Pezzo value) {
		if (this.pezzo != value) {
			Pezzo lpezzo = this.pezzo;
			this.pezzo = value;
			if (value != null) {
				pezzo.setRigaRDA(this);
			}
			if (lpezzo != null && lpezzo.getRigaRDA() == this) {
				lpezzo.setRigaRDA(null);
			}
		}
	}
	@XmlTransient
	public Pezzo getPezzo() {
		return pezzo;
	}

	
	private int quantitaPezziOrdinati;
	

	public String toString() {
		return String.valueOf(getID());
	}

}
