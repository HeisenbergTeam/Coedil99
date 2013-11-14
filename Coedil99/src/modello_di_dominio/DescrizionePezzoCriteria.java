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

public class DescrizionePezzoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression fornitore;
	public final FloatExpression diametro;
	public final FloatExpression peso;
	
	public DescrizionePezzoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		fornitore = new StringExpression("fornitore", this);
		diametro = new FloatExpression("diametro", this);
		peso = new FloatExpression("peso", this);
	}
	
	public DescrizionePezzoCriteria(PersistentSession session) {
		this(session.createCriteria(DescrizionePezzo.class));
	}
	
	public DescrizionePezzoCriteria() throws PersistentException {
		this(modello_di_dominio.Coedil99PersistentManager.instance().getSession());
	}
	
	public modello_di_dominio.LavorazionePezzoCriteria createLavorazionePezzoCriteria() {
		return new modello_di_dominio.LavorazionePezzoCriteria(createCriteria("ORM_LavorazionePezzo"));
	}
	
	public DescrizionePezzo uniqueDescrizionePezzo() {
		return (DescrizionePezzo) super.uniqueResult();
	}
	
	public DescrizionePezzo[] listDescrizionePezzo() {
		java.util.List list = super.list();
		return (DescrizionePezzo[]) list.toArray(new DescrizionePezzo[list.size()]);
	}
}

