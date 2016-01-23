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

public class RigaRDACriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression pezzoId;
	public final AssociationExpression pezzo;
	public final IntegerExpression rdaId;
	public final AssociationExpression rda;
	public final StringExpression indicazione;
	
	public RigaRDACriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		pezzoId = new IntegerExpression("pezzo.ID", this);
		pezzo = new AssociationExpression("pezzo", this);
		rdaId = new IntegerExpression("rda.ID", this);
		rda = new AssociationExpression("rda", this);
		indicazione = new StringExpression("indicazione", this);
	}
	
	public RigaRDACriteria(PersistentSession session) {
		this(session.createCriteria(RigaRDA.class));
	}
	
	public RigaRDACriteria() throws PersistentException {
		this(com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public PezzoCriteria createPezzoCriteria() {
		return new PezzoCriteria(createCriteria("pezzo"));
	}
	
	public RDACriteria createRdaCriteria() {
		return new RDACriteria(createCriteria("rda"));
	}
	
	public RigaRDA uniqueRigaRDA() {
		return (RigaRDA) super.uniqueResult();
	}
	
	public RigaRDA[] listRigaRDA() {
		java.util.List list = super.list();
		return (RigaRDA[]) list.toArray(new RigaRDA[list.size()]);
	}
}

