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
import org.orm.criteria.StringExpression;

import java.util.List;

public class SagomaDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression ID;
    public final StringExpression img;
    public final IntegerExpression lavorazionePezzoId;
    public final AssociationExpression lavorazionePezzo;

    public SagomaDetachedCriteria() {
        super(Sagoma.class, SagomaCriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        img = new StringExpression("img", this.getDetachedCriteria());
        lavorazionePezzoId = new IntegerExpression("lavorazionePezzo.ID", this.getDetachedCriteria());
        lavorazionePezzo = new AssociationExpression("lavorazionePezzo", this.getDetachedCriteria());
    }

    public SagomaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, SagomaCriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        img = new StringExpression("img", this.getDetachedCriteria());
        lavorazionePezzoId = new IntegerExpression("lavorazionePezzo.ID", this.getDetachedCriteria());
        lavorazionePezzo = new AssociationExpression("lavorazionePezzo", this.getDetachedCriteria());
    }

    public LavorazionePezzoDetachedCriteria createLavorazionePezzoCriteria() {
        return new LavorazionePezzoDetachedCriteria(createCriteria("lavorazionePezzo"));
    }

    public Sagoma uniqueSagoma(PersistentSession session) {
        return (Sagoma) super.createExecutableCriteria(session).uniqueResult();
    }

    public Sagoma[] listSagoma(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Sagoma[]) list.toArray(new Sagoma[list.size()]);
    }
}

