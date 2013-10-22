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

public class RigaDistinta {
	public RigaDistinta() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_PEZZO) {
			this.pezzo = (modello_di_dominio.Pezzo) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_DISTINTA) {
			this.distinta = (modello_di_dominio.Distinta) owner;
		}
		
		else if (key == modello_di_dominio.ORMConstants.KEY_RIGADISTINTA_LAVORAZIONEPEZZO) {
			this.lavorazionePezzo = (modello_di_dominio.LavorazionePezzo) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private modello_di_dominio.Pezzo pezzo;
	
	private modello_di_dominio.Distinta distinta;
	
	private modello_di_dominio.LavorazionePezzo lavorazionePezzo;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setPezzo(modello_di_dominio.Pezzo value) {
		this.pezzo = value;
	}
	
	public modello_di_dominio.Pezzo getPezzo() {
		return pezzo;
	}
	
	public void setDistinta(modello_di_dominio.Distinta value) {
		if (distinta != null) {
			distinta.righeDistinta.remove(this);
		}
		if (value != null) {
			value.righeDistinta.add(this);
		}
	}
	
	public modello_di_dominio.Distinta getDistinta() {
		return distinta;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Distinta(modello_di_dominio.Distinta value) {
		this.distinta = value;
	}
	
	private modello_di_dominio.Distinta getORM_Distinta() {
		return distinta;
	}
	
	public void setLavorazionePezzo(modello_di_dominio.LavorazionePezzo value) {
		this.lavorazionePezzo = value;
	}
	
	public modello_di_dominio.LavorazionePezzo getLavorazionePezzo() {
		return lavorazionePezzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
