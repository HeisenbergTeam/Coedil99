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

import java.util.List;

public class OrdineDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public OrdineDetachedCriteria() {
		super(Ordine.class, OrdineCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public OrdineDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, OrdineCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public DestinazioneDetachedCriteria createDestinazioneCriteria() {
		return new DestinazioneDetachedCriteria(createCriteria("destinazione"));
	}
	
	public CommessaDetachedCriteria createCommesseCriteria() {
		return new CommessaDetachedCriteria(createCriteria("ORM_Commesse"));
	}
	
	public Ordine uniqueOrdine(PersistentSession session) {
		return (Ordine) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ordine[] listOrdine(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ordine[]) list.toArray(new Ordine[list.size()]);
	}
}

