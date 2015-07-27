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

public class DescrizionePezzo {
	public DescrizionePezzo() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_DESCRIZIONEPEZZO_LAVORAZIONEPEZZO) {
			return ORM_lavorazionePezzo;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private String nome;
	
	private String fornitore;
	
	private float diametro;
	
	private float peso;
	
	private java.util.Set ORM_lavorazionePezzo = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setFornitore(String value) {
		this.fornitore = value;
	}
	
	public String getFornitore() {
		return fornitore;
	}
	
	public void setDiametro(float value) {
		this.diametro = value;
	}
	
	public float getDiametro() {
		return diametro;
	}
	
	public void setPeso(float value) {
		this.peso = value;
	}
	
	public float getPeso() {
		return peso;
	}
	
	private void setORM_LavorazionePezzo(java.util.Set value) {
		this.ORM_lavorazionePezzo = value;
	}
	
	private java.util.Set getORM_LavorazionePezzo() {
		return ORM_lavorazionePezzo;
	}
	
	public final LavorazionePezzoSetCollection lavorazionePezzo = new LavorazionePezzoSetCollection(this, _ormAdapter, ORMConstants.KEY_DESCRIZIONEPEZZO_LAVORAZIONEPEZZO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
