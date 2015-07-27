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

public class RigaDistintaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression indicazione;
	
	public RigaDistintaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		indicazione = new StringExpression("indicazione", this);
	}
	
	public RigaDistintaCriteria(PersistentSession session) {
		this(session.createCriteria(RigaDistinta.class));
	}
	
	public RigaDistintaCriteria() throws PersistentException {
		this(Coedil99PersistentManager.instance().getSession());
	}
	
	public PezzoCriteria createPezzoCriteria() {
		return new PezzoCriteria(createCriteria("pezzo"));
	}
	
	public DistintaCriteria createDistintaCriteria() {
		return new DistintaCriteria(createCriteria("distinta"));
	}
	
	public LavorazionePezzoCriteria createLavorazionePezzoCriteria() {
		return new LavorazionePezzoCriteria(createCriteria("lavorazionePezzo"));
	}
	
	public RigaDistinta uniqueRigaDistinta() {
		return (RigaDistinta) super.uniqueResult();
	}
	
	public RigaDistinta[] listRigaDistinta() {
		java.util.List list = super.list();
		return (RigaDistinta[]) list.toArray(new RigaDistinta[list.size()]);
	}
}

