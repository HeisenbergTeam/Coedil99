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

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import java.util.List;

public class RigaDistintaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression indicazione;
	
	public RigaDistintaDetachedCriteria() {
		super(RigaDistinta.class, RigaDistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indicazione = new StringExpression("indicazione", this.getDetachedCriteria());
	}
	
	public RigaDistintaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, RigaDistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indicazione = new StringExpression("indicazione", this.getDetachedCriteria());
	}
	
	public PezzoDetachedCriteria createPezzoCriteria() {
		return new PezzoDetachedCriteria(createCriteria("pezzo"));
	}
	
	public DistintaDetachedCriteria createDistintaCriteria() {
		return new DistintaDetachedCriteria(createCriteria("distinta"));
	}
	
	public LavorazionePezzoDetachedCriteria createLavorazionePezzoCriteria() {
		return new LavorazionePezzoDetachedCriteria(createCriteria("lavorazionePezzo"));
	}
	
	public RigaDistinta uniqueRigaDistinta(PersistentSession session) {
		return (RigaDistinta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RigaDistinta[] listRigaDistinta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RigaDistinta[]) list.toArray(new RigaDistinta[list.size()]);
	}
}
