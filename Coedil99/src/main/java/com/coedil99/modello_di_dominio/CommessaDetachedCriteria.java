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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommessaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression ordineId;
	public final AssociationExpression ordine;
	public final DateExpression dataCreazione;
	public final IntegerExpression distintaId;
	public final AssociationExpression distinta;
	
	public CommessaDetachedCriteria() {
		super(com.coedil99.modello_di_dominio.Commessa.class, com.coedil99.modello_di_dominio.CommessaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		ordineId = new IntegerExpression("ordine.ID", this.getDetachedCriteria());
		ordine = new AssociationExpression("ordine", this.getDetachedCriteria());
		dataCreazione = new DateExpression("dataCreazione", this.getDetachedCriteria());
		distintaId = new IntegerExpression("distinta.ID", this.getDetachedCriteria());
		distinta = new AssociationExpression("distinta", this.getDetachedCriteria());
	}
	
	public CommessaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.coedil99.modello_di_dominio.CommessaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		ordineId = new IntegerExpression("ordine.ID", this.getDetachedCriteria());
		ordine = new AssociationExpression("ordine", this.getDetachedCriteria());
		dataCreazione = new DateExpression("dataCreazione", this.getDetachedCriteria());
		distintaId = new IntegerExpression("distinta.ID", this.getDetachedCriteria());
		distinta = new AssociationExpression("distinta", this.getDetachedCriteria());
	}
	
	public OrdineDetachedCriteria createOrdineCriteria() {
		return new OrdineDetachedCriteria(createCriteria("ordine"));
	}
	
	public DistintaDetachedCriteria createDistintaCriteria() {
		return new DistintaDetachedCriteria(createCriteria("distinta"));
	}
	
	public Commessa uniqueCommessa(PersistentSession session) {
		return (Commessa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Commessa[] listCommessa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Commessa[]) list.toArray(new Commessa[list.size()]);
	}
}

