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

public class PezzoDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression ID;
    public final DateExpression dataArrivo;
    public final IntegerExpression quantita;
    public final IntegerExpression descrizionePezzoId;
    public final AssociationExpression descrizionePezzo;
    public final CollectionExpression rigaRDA;

    public PezzoDetachedCriteria() {
        super(Pezzo.class, PezzoCriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        dataArrivo = new DateExpression("dataArrivo", this.getDetachedCriteria());
        quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
        descrizionePezzoId = new IntegerExpression("descrizionePezzo.ID", this.getDetachedCriteria());
        descrizionePezzo = new AssociationExpression("descrizionePezzo", this.getDetachedCriteria());
        rigaRDA = new CollectionExpression("ORM_RigaRDA", this.getDetachedCriteria());
    }

    public PezzoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, PezzoCriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        dataArrivo = new DateExpression("dataArrivo", this.getDetachedCriteria());
        quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
        descrizionePezzoId = new IntegerExpression("descrizionePezzo.ID", this.getDetachedCriteria());
        descrizionePezzo = new AssociationExpression("descrizionePezzo", this.getDetachedCriteria());
        rigaRDA = new CollectionExpression("ORM_RigaRDA", this.getDetachedCriteria());
    }

    public DescrizionePezzoDetachedCriteria createDescrizionePezzoCriteria() {
        return new DescrizionePezzoDetachedCriteria(createCriteria("descrizionePezzo"));
    }

    public RigaRDADetachedCriteria createRigaRDACriteria() {
        return new RigaRDADetachedCriteria(createCriteria("ORM_RigaRDA"));
    }

    public Pezzo uniquePezzo(PersistentSession session) {
        return (Pezzo) super.createExecutableCriteria(session).uniqueResult();
    }

    public Pezzo[] listPezzo(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Pezzo[]) list.toArray(new Pezzo[list.size()]);
    }
}

