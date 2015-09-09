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
import org.orm.criteria.*;

import java.util.List;

public class RDADetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression ID;
    public final IntegerExpression fornitoreId;
    public final AssociationExpression fornitore;
    public final StringExpression descrizione;
    public final DateExpression dataCreazione;
    public final CollectionExpression righeRDA;

    public RDADetachedCriteria() {
        super(RDA.class, RDACriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        fornitoreId = new IntegerExpression("fornitore.ID", this.getDetachedCriteria());
        fornitore = new AssociationExpression("fornitore", this.getDetachedCriteria());
        descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
        dataCreazione = new DateExpression("dataCreazione", this.getDetachedCriteria());
        righeRDA = new CollectionExpression("ORM_RigheRDA", this.getDetachedCriteria());
    }

    public RDADetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, RDACriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        fornitoreId = new IntegerExpression("fornitore.ID", this.getDetachedCriteria());
        fornitore = new AssociationExpression("fornitore", this.getDetachedCriteria());
        descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
        dataCreazione = new DateExpression("dataCreazione", this.getDetachedCriteria());
        righeRDA = new CollectionExpression("ORM_RigheRDA", this.getDetachedCriteria());
    }

    public FornitoreDetachedCriteria createFornitoreCriteria() {
        return new FornitoreDetachedCriteria(createCriteria("fornitore"));
    }

    public RigaRDADetachedCriteria createRigheRDACriteria() {
        return new RigaRDADetachedCriteria(createCriteria("ORM_RigheRDA"));
    }

    public RDA uniqueRDA(PersistentSession session) {
        return (RDA) super.createExecutableCriteria(session).uniqueResult();
    }

    public RDA[] listRDA(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (RDA[]) list.toArray(new RDA[list.size()]);
    }
}

