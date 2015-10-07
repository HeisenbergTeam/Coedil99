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

public class RDACriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression fornitoreId;
	public final AssociationExpression fornitore;
	public final StringExpression descrizione;
	public final DateExpression dataCreazione;
	public final DateExpression dataArrivoPrevista;
	public final DateExpression dataArrivoEffettiva;
	public final CollectionExpression righeRDA;
	
	public RDACriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		fornitoreId = new IntegerExpression("fornitore.ID", this);
		fornitore = new AssociationExpression("fornitore", this);
		descrizione = new StringExpression("descrizione", this);
		dataCreazione = new DateExpression("dataCreazione", this);
		dataArrivoPrevista = new DateExpression("dataArrivoPrevista", this);
		dataArrivoEffettiva = new DateExpression("dataArrivoEffettiva", this);
		righeRDA = new CollectionExpression("ORM_RigheRDA", this);
	}
	
	public RDACriteria(PersistentSession session) {
		this(session.createCriteria(RDA.class));
	}
	
	public RDACriteria() throws PersistentException {
		this(com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public FornitoreCriteria createFornitoreCriteria() {
		return new FornitoreCriteria(createCriteria("fornitore"));
	}
	
	public RigaRDACriteria createRigheRDACriteria() {
		return new RigaRDACriteria(createCriteria("ORM_RigheRDA"));
	}
	
	public RDA uniqueRDA() {
		return (RDA) super.uniqueResult();
	}
	
	public RDA[] listRDA() {
		java.util.List list = super.list();
		return (RDA[]) list.toArray(new RDA[list.size()]);
	}
}

