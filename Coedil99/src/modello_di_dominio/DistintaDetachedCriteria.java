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
package modello_di_dominio;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DistintaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public DistintaDetachedCriteria() {
		super(modello_di_dominio.Distinta.class, modello_di_dominio.DistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public DistintaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, modello_di_dominio.DistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public CommessaDetachedCriteria createCommessaCriteria() {
		return new CommessaDetachedCriteria(createCriteria("commessa"));
	}
	
	public modello_di_dominio.RigaDistintaDetachedCriteria createRigheDistintaCriteria() {
		return new modello_di_dominio.RigaDistintaDetachedCriteria(createCriteria("ORM_RigheDistinta"));
	}
	
	public Distinta uniqueDistinta(PersistentSession session) {
		return (Distinta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Distinta[] listDistinta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Distinta[]) list.toArray(new Distinta[list.size()]);
	}
}

