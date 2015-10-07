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

public class CommessaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression priorita;
	public final IntegerExpression ordineId;
	public final AssociationExpression ordine;
	public final DateExpression dataCreazione;
	public final IntegerExpression distintaId;
	public final AssociationExpression distinta;
	
	public CommessaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		priorita = new IntegerExpression("priorita", this);
		ordineId = new IntegerExpression("ordine.ID", this);
		ordine = new AssociationExpression("ordine", this);
		dataCreazione = new DateExpression("dataCreazione", this);
		distintaId = new IntegerExpression("distinta.ID", this);
		distinta = new AssociationExpression("distinta", this);
	}
	
	public CommessaCriteria(PersistentSession session) {
		this(session.createCriteria(Commessa.class));
	}
	
	public CommessaCriteria() throws PersistentException {
		this(com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public OrdineCriteria createOrdineCriteria() {
		return new OrdineCriteria(createCriteria("ordine"));
	}
	
	public DistintaCriteria createDistintaCriteria() {
		return new DistintaCriteria(createCriteria("distinta"));
	}
	
	public Commessa uniqueCommessa() {
		return (Commessa) super.uniqueResult();
	}
	
	public Commessa[] listCommessa() {
		java.util.List list = super.list();
		return (Commessa[]) list.toArray(new Commessa[list.size()]);
	}
}

