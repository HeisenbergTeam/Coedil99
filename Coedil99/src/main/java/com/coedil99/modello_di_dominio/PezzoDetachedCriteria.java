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

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.IntegerExpression;

import java.util.List;

public class PezzoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression quantitaOrdinate;
	public final IntegerExpression descrizionePezzoId;
	public final AssociationExpression descrizionePezzo;
	public final IntegerExpression rigaRDAId;
	public final AssociationExpression rigaRDA;
	
	public PezzoDetachedCriteria() {
		super(com.coedil99.modello_di_dominio.Pezzo.class, com.coedil99.modello_di_dominio.PezzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		quantitaOrdinate = new IntegerExpression("quantitaOrdinate", this.getDetachedCriteria());
		descrizionePezzoId = new IntegerExpression("descrizionePezzo.ID", this.getDetachedCriteria());
		descrizionePezzo = new AssociationExpression("descrizionePezzo", this.getDetachedCriteria());
		rigaRDAId = new IntegerExpression("rigaRDA.ID", this.getDetachedCriteria());
		rigaRDA = new AssociationExpression("rigaRDA", this.getDetachedCriteria());
	}

	public PezzoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.coedil99.modello_di_dominio.PezzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		quantitaOrdinate = new IntegerExpression("quantitaOrdinate", this.getDetachedCriteria());
		descrizionePezzoId = new IntegerExpression("descrizionePezzo.ID", this.getDetachedCriteria());
		descrizionePezzo = new AssociationExpression("descrizionePezzo", this.getDetachedCriteria());
		rigaRDAId = new IntegerExpression("rigaRDA.ID", this.getDetachedCriteria());
		rigaRDA = new AssociationExpression("rigaRDA", this.getDetachedCriteria());
	}
	
	public DescrizionePezzoDetachedCriteria createDescrizionePezzoCriteria() {
		return new DescrizionePezzoDetachedCriteria(createCriteria("descrizionePezzo"));
	}
	
	public RigaRDADetachedCriteria createRigaRDACriteria() {
		return new RigaRDADetachedCriteria(createCriteria("rigaRDA"));
	}
	
	public Pezzo uniquePezzo(PersistentSession session) {
		return (Pezzo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pezzo[] listPezzo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pezzo[]) list.toArray(new Pezzo[list.size()]);
	}
}

