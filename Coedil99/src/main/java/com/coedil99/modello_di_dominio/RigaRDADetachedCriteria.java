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

public class RigaRDADetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression ID;
    public final IntegerExpression pezzoId;
    public final AssociationExpression pezzo;
    public final IntegerExpression rdaId;
    public final AssociationExpression rda;
    public final StringExpression indicazione;

    public RigaRDADetachedCriteria() {
        super(RigaRDA.class, RigaRDACriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        pezzoId = new IntegerExpression("pezzo.ID", this.getDetachedCriteria());
        pezzo = new AssociationExpression("pezzo", this.getDetachedCriteria());
        rdaId = new IntegerExpression("rda.ID", this.getDetachedCriteria());
        rda = new AssociationExpression("rda", this.getDetachedCriteria());
        indicazione = new StringExpression("indicazione", this.getDetachedCriteria());
    }

    public RigaRDADetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, RigaRDACriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        pezzoId = new IntegerExpression("pezzo.ID", this.getDetachedCriteria());
        pezzo = new AssociationExpression("pezzo", this.getDetachedCriteria());
        rdaId = new IntegerExpression("rda.ID", this.getDetachedCriteria());
        rda = new AssociationExpression("rda", this.getDetachedCriteria());
        indicazione = new StringExpression("indicazione", this.getDetachedCriteria());
    }

    public PezzoDetachedCriteria createPezzoCriteria() {
        return new PezzoDetachedCriteria(createCriteria("pezzo"));
    }

    public RDADetachedCriteria createRdaCriteria() {
        return new RDADetachedCriteria(createCriteria("rda"));
    }

    public RigaRDA uniqueRigaRDA(PersistentSession session) {
        return (RigaRDA) super.createExecutableCriteria(session).uniqueResult();
    }

    public RigaRDA[] listRigaRDA(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (RigaRDA[]) list.toArray(new RigaRDA[list.size()]);
    }
}

