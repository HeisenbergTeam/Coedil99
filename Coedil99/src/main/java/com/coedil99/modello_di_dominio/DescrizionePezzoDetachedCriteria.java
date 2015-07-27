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
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import java.util.List;

public class DescrizionePezzoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression fornitore;
	public final FloatExpression diametro;
	public final FloatExpression peso;
	
	public DescrizionePezzoDetachedCriteria() {
		super(DescrizionePezzo.class, DescrizionePezzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		fornitore = new StringExpression("fornitore", this.getDetachedCriteria());
		diametro = new FloatExpression("diametro", this.getDetachedCriteria());
		peso = new FloatExpression("peso", this.getDetachedCriteria());
	}
	
	public DescrizionePezzoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DescrizionePezzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		fornitore = new StringExpression("fornitore", this.getDetachedCriteria());
		diametro = new FloatExpression("diametro", this.getDetachedCriteria());
		peso = new FloatExpression("peso", this.getDetachedCriteria());
	}
	
	public LavorazionePezzoDetachedCriteria createLavorazionePezzoCriteria() {
		return new LavorazionePezzoDetachedCriteria(createCriteria("ORM_LavorazionePezzo"));
	}
	
	public DescrizionePezzo uniqueDescrizionePezzo(PersistentSession session) {
		return (DescrizionePezzo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public DescrizionePezzo[] listDescrizionePezzo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (DescrizionePezzo[]) list.toArray(new DescrizionePezzo[list.size()]);
	}
}

