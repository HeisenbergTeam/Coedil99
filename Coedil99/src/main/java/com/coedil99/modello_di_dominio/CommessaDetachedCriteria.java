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

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.IntegerExpression;

import java.util.List;

public class CommessaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public CommessaDetachedCriteria() {
		super(Commessa.class, CommessaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public CommessaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, CommessaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public OrdineDetachedCriteria createOrdineCriteria() {
		return new OrdineDetachedCriteria(createCriteria("ordine"));
	}
	
	public DistintaDetachedCriteria createDistintaCriteria() {
		return new DistintaDetachedCriteria(createCriteria("distinta"));
	}
	
	public Commessa uniqueCommessa(PersistentSession session) {
		return (Commessa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Commessa[] listCommessa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Commessa[]) list.toArray(new Commessa[list.size()]);
	}
}
