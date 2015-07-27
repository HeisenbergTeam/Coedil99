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
import org.orm.criteria.StringExpression;

public class DestinazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression via;
	
	public DestinazioneCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		via = new StringExpression("via", this);
	}
	
	public DestinazioneCriteria(PersistentSession session) {
		this(session.createCriteria(Destinazione.class));
	}
	
	public DestinazioneCriteria() throws PersistentException {
		this(Coedil99PersistentManager.instance().getSession());
	}
	
	public OrdineCriteria createOrdineCriteria() {
		return new OrdineCriteria(createCriteria("ordine"));
	}
	
	public Destinazione uniqueDestinazione() {
		return (Destinazione) super.uniqueResult();
	}
	
	public Destinazione[] listDestinazione() {
		java.util.List list = super.list();
		return (Destinazione[]) list.toArray(new Destinazione[list.size()]);
	}
}

