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

public class DescrizionePezzoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression fornitoreId;
	public final AssociationExpression fornitore;
	public final StringExpression nome;
	public final FloatExpression diametro;
	public final FloatExpression peso;
	public final CollectionExpression lavorazionePezzo;
	
	public DescrizionePezzoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		fornitoreId = new IntegerExpression("fornitore.ID", this);
		fornitore = new AssociationExpression("fornitore", this);
		nome = new StringExpression("nome", this);
		diametro = new FloatExpression("diametro", this);
		peso = new FloatExpression("peso", this);
		lavorazionePezzo = new CollectionExpression("ORM_LavorazionePezzo", this);
	}
	
	public DescrizionePezzoCriteria(PersistentSession session) {
		this(session.createCriteria(DescrizionePezzo.class));
	}
	
	public DescrizionePezzoCriteria() throws PersistentException {
		this(com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public FornitoreCriteria createFornitoreCriteria() {
		return new FornitoreCriteria(createCriteria("fornitore"));
	}
	
	public LavorazionePezzoCriteria createLavorazionePezzoCriteria() {
		return new LavorazionePezzoCriteria(createCriteria("ORM_LavorazionePezzo"));
	}
	
	public DescrizionePezzo uniqueDescrizionePezzo() {
		return (DescrizionePezzo) super.uniqueResult();
	}
	
	public DescrizionePezzo[] listDescrizionePezzo() {
		java.util.List list = super.list();
		return (DescrizionePezzo[]) list.toArray(new DescrizionePezzo[list.size()]);
	}
}

