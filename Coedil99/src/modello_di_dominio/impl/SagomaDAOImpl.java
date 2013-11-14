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
package modello_di_dominio.impl;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;
import modello_di_dominio.*;

public class SagomaDAOImpl implements modello_di_dominio.dao.SagomaDAO {
	public Sagoma loadSagomaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadSagomaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma getSagomaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getSagomaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma loadSagomaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadSagomaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma getSagomaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getSagomaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma loadSagomaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Sagoma) session.load(modello_di_dominio.Sagoma.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma getSagomaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Sagoma) session.get(modello_di_dominio.Sagoma.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma loadSagomaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sagoma) session.load(modello_di_dominio.Sagoma.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma getSagomaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sagoma) session.get(modello_di_dominio.Sagoma.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List querySagoma(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return querySagoma(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List querySagoma(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return querySagoma(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma[] listSagomaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listSagomaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma[] listSagomaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listSagomaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List querySagoma(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Sagoma as Sagoma");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List querySagoma(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Sagoma as Sagoma");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma[] listSagomaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySagoma(session, condition, orderBy);
			return (Sagoma[]) list.toArray(new Sagoma[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma[] listSagomaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySagoma(session, condition, orderBy, lockMode);
			return (Sagoma[]) list.toArray(new Sagoma[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma loadSagomaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadSagomaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma loadSagomaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadSagomaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma loadSagomaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sagoma[] sagomas = listSagomaByQuery(session, condition, orderBy);
		if (sagomas != null && sagomas.length > 0)
			return sagomas[0];
		else
			return null;
	}
	
	public Sagoma loadSagomaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sagoma[] sagomas = listSagomaByQuery(session, condition, orderBy, lockMode);
		if (sagomas != null && sagomas.length > 0)
			return sagomas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSagomaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateSagomaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSagomaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateSagomaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSagomaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Sagoma as Sagoma");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSagomaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modello_di_dominio.Sagoma as Sagoma");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma createSagoma() {
		return new modello_di_dominio.Sagoma();
	}
	
	public boolean save(modello_di_dominio.Sagoma sagoma) throws PersistentException {
		try {
			modello_di_dominio.Coedil99PersistentManager.instance().saveObject(sagoma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(modello_di_dominio.Sagoma sagoma) throws PersistentException {
		try {
			modello_di_dominio.Coedil99PersistentManager.instance().deleteObject(sagoma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Sagoma sagoma)throws PersistentException {
		try {
			if(sagoma.getLavorazionePezzo() != null) {
				sagoma.getLavorazionePezzo().setSagoma(null);
			}
			
			return delete(sagoma);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(modello_di_dominio.Sagoma sagoma, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(sagoma.getLavorazionePezzo() != null) {
				sagoma.getLavorazionePezzo().setSagoma(null);
			}
			
			try {
				session.delete(sagoma);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(modello_di_dominio.Sagoma sagoma) throws PersistentException {
		try {
			modello_di_dominio.Coedil99PersistentManager.instance().getSession().refresh(sagoma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(modello_di_dominio.Sagoma sagoma) throws PersistentException {
		try {
			modello_di_dominio.Coedil99PersistentManager.instance().getSession().evict(sagoma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Sagoma loadSagomaByCriteria(SagomaCriteria sagomaCriteria) {
		Sagoma[] sagomas = listSagomaByCriteria(sagomaCriteria);
		if(sagomas == null || sagomas.length == 0) {
			return null;
		}
		return sagomas[0];
	}
	
	public Sagoma[] listSagomaByCriteria(SagomaCriteria sagomaCriteria) {
		return sagomaCriteria.listSagoma();
	}
}
