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

public class DistintaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DateExpression dataInizio;
	public final IntegerExpression commessaId;
	public final AssociationExpression commessa;
	public final IntegerExpression revisione;
	public final StringExpression modello;
	public final StringExpression elementoStrutturale;
	public final CollectionExpression righeDistinta;
	
	public DistintaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		dataInizio = new DateExpression("dataInizio", this);
		commessaId = new IntegerExpression("commessa.ID", this);
		commessa = new AssociationExpression("commessa", this);
		revisione = new IntegerExpression("revisione", this);
		modello = new StringExpression("modello", this);
		elementoStrutturale = new StringExpression("elementoStrutturale", this);
		righeDistinta = new CollectionExpression("ORM_RigheDistinta", this);
	}
	
	public DistintaCriteria(PersistentSession session) {
		this(session.createCriteria(Distinta.class));
	}
	
	public DistintaCriteria() throws PersistentException {
		this(com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public CommessaCriteria createCommessaCriteria() {
		return new CommessaCriteria(createCriteria("commessa"));
	}
	
	public RigaDistintaCriteria createRigheDistintaCriteria() {
		return new RigaDistintaCriteria(createCriteria("ORM_RigheDistinta"));
	}
	
	public Distinta uniqueDistinta() {
		return (Distinta) super.uniqueResult();
	}
	
	public Distinta[] listDistinta() {
		java.util.List list = super.list();
		return (Distinta[]) list.toArray(new Distinta[list.size()]);
	}
}

