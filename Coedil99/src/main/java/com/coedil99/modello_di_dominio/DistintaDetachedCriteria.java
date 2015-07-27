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

public class DistintaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression revisione;
	public final StringExpression modello;
	public final StringExpression elementoStrutturale;
	
	public DistintaDetachedCriteria() {
		super(Distinta.class, DistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		revisione = new IntegerExpression("revisione", this.getDetachedCriteria());
		modello = new StringExpression("modello", this.getDetachedCriteria());
		elementoStrutturale = new StringExpression("elementoStrutturale", this.getDetachedCriteria());
	}
	
	public DistintaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		revisione = new IntegerExpression("revisione", this.getDetachedCriteria());
		modello = new StringExpression("modello", this.getDetachedCriteria());
		elementoStrutturale = new StringExpression("elementoStrutturale", this.getDetachedCriteria());
	}
	
	public CommessaDetachedCriteria createCommessaCriteria() {
		return new CommessaDetachedCriteria(createCriteria("commessa"));
	}
	
	public RigaDistintaDetachedCriteria createRigheDistintaCriteria() {
		return new RigaDistintaDetachedCriteria(createCriteria("ORM_RigheDistinta"));
	}
	
	public Distinta uniqueDistinta(PersistentSession session) {
		return (Distinta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Distinta[] listDistinta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Distinta[]) list.toArray(new Distinta[list.size()]);
	}
}

