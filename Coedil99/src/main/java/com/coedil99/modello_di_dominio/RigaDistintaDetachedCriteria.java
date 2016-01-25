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

public class RigaDistintaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression pezzoId;
	public final AssociationExpression pezzo;
	public final IntegerExpression distintaId;
	public final AssociationExpression distinta;
	public final IntegerExpression lavorazionePezzoId;
	public final AssociationExpression lavorazionePezzo;
	public final IntegerExpression quantitaRigaDistinta;
	public final StringExpression indicazione;
	
	public RigaDistintaDetachedCriteria() {
		super(com.coedil99.modello_di_dominio.RigaDistinta.class, com.coedil99.modello_di_dominio.RigaDistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		pezzoId = new IntegerExpression("pezzo.ID", this.getDetachedCriteria());
		pezzo = new AssociationExpression("pezzo", this.getDetachedCriteria());
		distintaId = new IntegerExpression("distinta.ID", this.getDetachedCriteria());
		distinta = new AssociationExpression("distinta", this.getDetachedCriteria());
		lavorazionePezzoId = new IntegerExpression("lavorazionePezzo.ID", this.getDetachedCriteria());
		lavorazionePezzo = new AssociationExpression("lavorazionePezzo", this.getDetachedCriteria());
		quantitaRigaDistinta = new IntegerExpression("quantitaRigaDistinta", this.getDetachedCriteria());
		indicazione = new StringExpression("indicazione", this.getDetachedCriteria());
	}
	
	public RigaDistintaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.coedil99.modello_di_dominio.RigaDistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		pezzoId = new IntegerExpression("pezzo.ID", this.getDetachedCriteria());
		pezzo = new AssociationExpression("pezzo", this.getDetachedCriteria());
		distintaId = new IntegerExpression("distinta.ID", this.getDetachedCriteria());
		distinta = new AssociationExpression("distinta", this.getDetachedCriteria());
		lavorazionePezzoId = new IntegerExpression("lavorazionePezzo.ID", this.getDetachedCriteria());
		lavorazionePezzo = new AssociationExpression("lavorazionePezzo", this.getDetachedCriteria());
		quantitaRigaDistinta = new IntegerExpression("quantitaRigaDistinta", this.getDetachedCriteria());
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

