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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class LavorazionePezzoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	
	public LavorazionePezzoDetachedCriteria() {
		super(modello_di_dominio.LavorazionePezzo.class, modello_di_dominio.LavorazionePezzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
	}
	
	public LavorazionePezzoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.LavorazionePezzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
	}
	
	public LavorazionePezzo uniqueLavorazionePezzo(PersistentSession session) {
		return (LavorazionePezzo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public LavorazionePezzo[] listLavorazionePezzo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (LavorazionePezzo[]) list.toArray(new LavorazionePezzo[list.size()]);
	}
}

