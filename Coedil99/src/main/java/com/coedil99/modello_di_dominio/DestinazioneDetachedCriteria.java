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

public class DestinazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression via;
	public final IntegerExpression ordineId;
	public final AssociationExpression ordine;
	
	public DestinazioneDetachedCriteria() {
		super(com.coedil99.modello_di_dominio.Destinazione.class, com.coedil99.modello_di_dominio.DestinazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		via = new StringExpression("via", this.getDetachedCriteria());
		ordineId = new IntegerExpression("ordine.ID", this.getDetachedCriteria());
		ordine = new AssociationExpression("ordine", this.getDetachedCriteria());
	}
	
	public DestinazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.coedil99.modello_di_dominio.DestinazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		via = new StringExpression("via", this.getDetachedCriteria());
		ordineId = new IntegerExpression("ordine.ID", this.getDetachedCriteria());
		ordine = new AssociationExpression("ordine", this.getDetachedCriteria());
	}
	
	public OrdineDetachedCriteria createOrdineCriteria() {
		return new OrdineDetachedCriteria(createCriteria("ordine"));
	}
	
	public Destinazione uniqueDestinazione(PersistentSession session) {
		return (Destinazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Destinazione[] listDestinazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Destinazione[]) list.toArray(new Destinazione[list.size()]);
	}
}

