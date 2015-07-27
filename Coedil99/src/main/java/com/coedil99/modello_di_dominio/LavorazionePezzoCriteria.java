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
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class LavorazionePezzoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final FloatExpression misuraDiTaglio;
	public final FloatExpression peso;
	
	public LavorazionePezzoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		descrizione = new StringExpression("descrizione", this);
		misuraDiTaglio = new FloatExpression("misuraDiTaglio", this);
		peso = new FloatExpression("peso", this);
	}
	
	public LavorazionePezzoCriteria(PersistentSession session) {
		this(session.createCriteria(LavorazionePezzo.class));
	}
	
	public LavorazionePezzoCriteria() throws PersistentException {
		this(Coedil99PersistentManager.instance().getSession());
	}
	
	public SagomaCriteria createSagomaCriteria() {
		return new SagomaCriteria(createCriteria("sagoma"));
	}
	
	public LavorazionePezzo uniqueLavorazionePezzo() {
		return (LavorazionePezzo) super.uniqueResult();
	}
	
	public LavorazionePezzo[] listLavorazionePezzo() {
		java.util.List list = super.list();
		return (LavorazionePezzo[]) list.toArray(new LavorazionePezzo[list.size()]);
	}
}

