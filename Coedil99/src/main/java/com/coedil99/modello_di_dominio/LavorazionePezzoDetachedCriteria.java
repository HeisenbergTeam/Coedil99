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

public class LavorazionePezzoDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression ID;
    public final StringExpression descrizione;
    public final FloatExpression misuraDiTaglio;
    public final FloatExpression peso;
    public final IntegerExpression sagomaId;
    public final AssociationExpression sagoma;

    public LavorazionePezzoDetachedCriteria() {
        super(LavorazionePezzo.class, LavorazionePezzoCriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
        misuraDiTaglio = new FloatExpression("misuraDiTaglio", this.getDetachedCriteria());
        peso = new FloatExpression("peso", this.getDetachedCriteria());
        sagomaId = new IntegerExpression("sagoma.ID", this.getDetachedCriteria());
        sagoma = new AssociationExpression("sagoma", this.getDetachedCriteria());
    }

    public LavorazionePezzoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, LavorazionePezzoCriteria.class);
        ID = new IntegerExpression("ID", this.getDetachedCriteria());
        descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
        misuraDiTaglio = new FloatExpression("misuraDiTaglio", this.getDetachedCriteria());
        peso = new FloatExpression("peso", this.getDetachedCriteria());
        sagomaId = new IntegerExpression("sagoma.ID", this.getDetachedCriteria());
        sagoma = new AssociationExpression("sagoma", this.getDetachedCriteria());
    }

    public SagomaDetachedCriteria createSagomaCriteria() {
        return new SagomaDetachedCriteria(createCriteria("sagoma"));
    }

    public LavorazionePezzo uniqueLavorazionePezzo(PersistentSession session) {
        return (LavorazionePezzo) super.createExecutableCriteria(session).uniqueResult();
    }

    public LavorazionePezzo[] listLavorazionePezzo(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (LavorazionePezzo[]) list.toArray(new LavorazionePezzo[list.size()]);
    }
}

