/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.coedil99.modello_di_dominio;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import java.util.List;

public class FornitoreDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final CollectionExpression rda;
	public final CollectionExpression descrizionePezzo;
	
	public FornitoreDetachedCriteria() {
		super(Fornitore.class, FornitoreCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		rda = new CollectionExpression("ORM_Rda", this.getDetachedCriteria());
		descrizionePezzo = new CollectionExpression("ORM_DescrizionePezzo", this.getDetachedCriteria());
	}
	
	public FornitoreDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, FornitoreCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		rda = new CollectionExpression("ORM_Rda", this.getDetachedCriteria());
		descrizionePezzo = new CollectionExpression("ORM_DescrizionePezzo", this.getDetachedCriteria());
	}
	
	public RDADetachedCriteria createRdaCriteria() {
		return new RDADetachedCriteria(createCriteria("ORM_Rda"));
	}
	
	public DescrizionePezzoDetachedCriteria createDescrizionePezzoCriteria() {
		return new DescrizionePezzoDetachedCriteria(createCriteria("ORM_DescrizionePezzo"));
	}
	
	public Fornitore uniqueFornitore(PersistentSession session) {
		return (Fornitore) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Fornitore[] listFornitore(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Fornitore[]) list.toArray(new Fornitore[list.size()]);
	}
}

