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

public class Pezzo {
	public Pezzo() {
	}
	
	private int ID;
	
	private Date dataArrivo;
	
	private int quantita;
	
	private modello_di_dominio.DescrizionePezzo descrizionePezzo;
	
	private String stato;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDataArrivo(Date value) {
		this.dataArrivo = value;
	}
	
	public Date getDataArrivo() {
		return dataArrivo;
	}
	
	public void setQuantita(int value) {
		this.quantita = value;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setDescrizionePezzo(modello_di_dominio.DescrizionePezzo value) {
		this.descrizionePezzo = value;
	}
	
	public modello_di_dominio.DescrizionePezzo getDescrizionePezzo() {
		return descrizionePezzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
	public String getStato() {
		return this.stato;
	}
	
	public void setStato(String stato) {
		this.stato = stato;
	}
	
}
