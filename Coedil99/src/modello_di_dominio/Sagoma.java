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

public class Sagoma {
	public Sagoma() {
	}
	
	private int ID;
	
	private String img;
	
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
	
	public void setImg(String value) {
		this.img = value;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setLavorazionePezzo(modello_di_dominio.LavorazionePezzo value) {
		if (this.lavorazionePezzo != value) {
			modello_di_dominio.LavorazionePezzo llavorazionePezzo = this.lavorazionePezzo;
			this.lavorazionePezzo = value;
			if (value != null) {
				lavorazionePezzo.setSagoma(this);
			}
			else {
				llavorazionePezzo.setSagoma(null);
			}
		}
	}
	
	public modello_di_dominio.LavorazionePezzo getLavorazionePezzo() {
		return lavorazionePezzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
