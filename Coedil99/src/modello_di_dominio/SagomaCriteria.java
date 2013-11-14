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

public class SagomaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression img;
	
	public SagomaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		img = new StringExpression("img", this);
	}
	
	public SagomaCriteria(PersistentSession session) {
		this(session.createCriteria(Sagoma.class));
	}
	
	public SagomaCriteria() throws PersistentException {
		this(modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public LavorazionePezzoCriteria createLavorazionePezzoCriteria() {
		return new LavorazionePezzoCriteria(createCriteria("lavorazionePezzo"));
	}
	
	public Sagoma uniqueSagoma() {
		return (Sagoma) super.uniqueResult();
	}
	
	public Sagoma[] listSagoma() {
		java.util.List list = super.list();
		return (Sagoma[]) list.toArray(new Sagoma[list.size()]);
	}
}

