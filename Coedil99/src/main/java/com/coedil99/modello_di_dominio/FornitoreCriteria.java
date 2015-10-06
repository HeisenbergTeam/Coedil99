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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class FornitoreCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final CollectionExpression rda;
	public final CollectionExpression descrizionePezzo;
	
	public FornitoreCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		rda = new CollectionExpression("ORM_Rda", this);
		descrizionePezzo = new CollectionExpression("ORM_DescrizionePezzo", this);
	}
	
	public FornitoreCriteria(PersistentSession session) {
		this(session.createCriteria(Fornitore.class));
	}
	
	public FornitoreCriteria() throws PersistentException {
		this(com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public RDACriteria createRdaCriteria() {
		return new RDACriteria(createCriteria("ORM_Rda"));
	}
	
	public DescrizionePezzoCriteria createDescrizionePezzoCriteria() {
		return new DescrizionePezzoCriteria(createCriteria("ORM_DescrizionePezzo"));
	}
	
	public Fornitore uniqueFornitore() {
		return (Fornitore) super.uniqueResult();
	}
	
	public Fornitore[] listFornitore() {
		java.util.List list = super.list();
		return (Fornitore[]) list.toArray(new Fornitore[list.size()]);
	}
}

