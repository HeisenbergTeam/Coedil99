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

public class DescrizionePezzo {
	public DescrizionePezzo() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == modello_di_dominio.ORMConstants.KEY_DESCRIZIONEPEZZO_LAVORAZIONEPEZZO) {
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
	
	private void setORM_LavorazionePezzo(java.util.Set value) {
		this.ORM_lavorazionePezzo = value;
	}
	
	private java.util.Set getORM_LavorazionePezzo() {
		return ORM_lavorazionePezzo;
	}
	
	public final modello_di_dominio.LavorazionePezzoSetCollection lavorazionePezzo = new modello_di_dominio.LavorazionePezzoSetCollection(this, _ormAdapter, modello_di_dominio.ORMConstants.KEY_DESCRIZIONEPEZZO_LAVORAZIONEPEZZO, modello_di_dominio.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
