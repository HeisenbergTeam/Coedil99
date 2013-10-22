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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DistintaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public DistintaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public DistintaCriteria(PersistentSession session) {
		this(session.createCriteria(Distinta.class));
	}
	
	public DistintaCriteria() throws PersistentException {
		this(modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public CommessaCriteria createCommessaCriteria() {
		return new CommessaCriteria(createCriteria("commessa"));
	}
	
	public modello_di_dominio.RigaDistintaCriteria createRigheDistintaCriteria() {
		return new modello_di_dominio.RigaDistintaCriteria(createCriteria("ORM_RigheDistinta"));
	}
	
	public Distinta uniqueDistinta() {
		return (Distinta) super.uniqueResult();
	}
	
	public Distinta[] listDistinta() {
		java.util.List list = super.list();
		return (Distinta[]) list.toArray(new Distinta[list.size()]);
	}
}

