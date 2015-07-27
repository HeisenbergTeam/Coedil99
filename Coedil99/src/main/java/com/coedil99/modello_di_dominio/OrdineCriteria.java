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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.IntegerExpression;

public class OrdineCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public OrdineCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public OrdineCriteria(PersistentSession session) {
		this(session.createCriteria(Ordine.class));
	}
	
	public OrdineCriteria() throws PersistentException {
		this(Coedil99PersistentManager.instance().getSession());
	}
	
	public DestinazioneCriteria createDestinazioneCriteria() {
		return new DestinazioneCriteria(createCriteria("destinazione"));
	}
	
	public CommessaCriteria createCommesseCriteria() {
		return new CommessaCriteria(createCriteria("ORM_Commesse"));
	}
	
	public Ordine uniqueOrdine() {
		return (Ordine) super.uniqueResult();
	}
	
	public Ordine[] listOrdine() {
		java.util.List list = super.list();
		return (Ordine[]) list.toArray(new Ordine[list.size()]);
	}
}

