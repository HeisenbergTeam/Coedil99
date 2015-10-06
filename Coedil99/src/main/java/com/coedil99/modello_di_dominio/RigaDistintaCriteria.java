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

public class RigaDistintaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression pezzoId;
	public final AssociationExpression pezzo;
	public final IntegerExpression distintaId;
	public final AssociationExpression distinta;
	public final IntegerExpression lavorazionePezzoId;
	public final AssociationExpression lavorazionePezzo;
	public final StringExpression indicazione;
	
	public RigaDistintaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		pezzoId = new IntegerExpression("pezzo.ID", this);
		pezzo = new AssociationExpression("pezzo", this);
		distintaId = new IntegerExpression("distinta.ID", this);
		distinta = new AssociationExpression("distinta", this);
		lavorazionePezzoId = new IntegerExpression("lavorazionePezzo.ID", this);
		lavorazionePezzo = new AssociationExpression("lavorazionePezzo", this);
		indicazione = new StringExpression("indicazione", this);
	}
	
	public RigaDistintaCriteria(PersistentSession session) {
		this(session.createCriteria(RigaDistinta.class));
	}
	
	public RigaDistintaCriteria() throws PersistentException {
		this(com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession());
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

