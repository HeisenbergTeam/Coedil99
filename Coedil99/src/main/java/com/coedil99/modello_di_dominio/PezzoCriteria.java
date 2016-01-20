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

public class PezzoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression quantita;
	public final IntegerExpression descrizionePezzoId;
	public final AssociationExpression descrizionePezzo;
	public final IntegerExpression rigaRDAId;
	public final AssociationExpression rigaRDA;
	
	public PezzoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		quantita = new IntegerExpression("quantita", this);
		descrizionePezzoId = new IntegerExpression("descrizionePezzo.ID", this);
		descrizionePezzo = new AssociationExpression("descrizionePezzo", this);
		rigaRDAId = new IntegerExpression("rigaRDA.ID", this);
		rigaRDA = new AssociationExpression("rigaRDA", this);
	}
	
	public PezzoCriteria(PersistentSession session) {
		this(session.createCriteria(Pezzo.class));
	}
	
	public PezzoCriteria() throws PersistentException {
		this(com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public DescrizionePezzoCriteria createDescrizionePezzoCriteria() {
		return new DescrizionePezzoCriteria(createCriteria("descrizionePezzo"));
	}
	
	public RigaRDACriteria createRigaRDACriteria() {
		return new RigaRDACriteria(createCriteria("rigaRDA"));
	}
	
	public Pezzo uniquePezzo() {
		return (Pezzo) super.uniqueResult();
	}
	
	public Pezzo[] listPezzo() {
		java.util.List list = super.list();
		return (Pezzo[]) list.toArray(new Pezzo[list.size()]);
	}
}

