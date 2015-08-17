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
package com.coedil99.modello_di_dominio.impl;

import com.coedil99.modello_di_dominio.Coedil99PersistentManager;
import com.coedil99.modello_di_dominio.Distinta;
import com.coedil99.modello_di_dominio.DistintaCriteria;
import com.coedil99.modello_di_dominio.RigaDistinta;
import com.coedil99.modello_di_dominio.dao.DistintaDAO;
import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.List;

public class DistintaDAOImpl implements DistintaDAO {
	public Distinta loadDistintaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return loadDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta getDistintaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return getDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta loadDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return loadDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta getDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return getDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta loadDistintaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Distinta) session.load(Distinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta getDistintaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Distinta) session.get(Distinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta loadDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Distinta) session.load(Distinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta getDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Distinta) session.get(Distinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryDistinta(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return queryDistinta(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryDistinta(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return queryDistinta(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta[] listDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return listDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta[] listDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return listDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryDistinta(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Distinta as Distinta");
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
	
	public List queryDistinta(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Distinta as Distinta");
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
	
	public Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDistinta(session, condition, orderBy);
			return (Distinta[]) list.toArray(new Distinta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDistinta(session, condition, orderBy, lockMode);
			return (Distinta[]) list.toArray(new Distinta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta loadDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return loadDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta loadDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return loadDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Distinta[] distintas = listDistintaByQuery(session, condition, orderBy);
		if (distintas != null && distintas.length > 0)
			return distintas[0];
		else
			return null;
	}
	
	public Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Distinta[] distintas = listDistintaByQuery(session, condition, orderBy, lockMode);
		if (distintas != null && distintas.length > 0)
			return distintas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return iterateDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Coedil99PersistentManager.instance().getSession();
			return iterateDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Distinta as Distinta");
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
	
	public static java.util.Iterator iterateDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Distinta as Distinta");
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
	
	public Distinta createDistinta() {
		return new Distinta();
	}
	
	public boolean save(Distinta distinta) throws PersistentException {
		try {
			Coedil99PersistentManager.instance().saveObject(distinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(Distinta distinta) throws PersistentException {
		try {
			Coedil99PersistentManager.instance().deleteObject(distinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(Distinta distinta)throws PersistentException {
		try {
			if(distinta.getCommessa() != null) {
				distinta.getCommessa().setDistinta(null);
			}
			
			RigaDistinta[] lRigheDistintas = distinta.righeDistinta.toArray();
			for(int i = 0; i < lRigheDistintas.length; i++) {
				lRigheDistintas[i].setDistinta(null);
			}
			return delete(distinta);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(Distinta distinta, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(distinta.getCommessa() != null) {
				distinta.getCommessa().setDistinta(null);
			}
			
			RigaDistinta[] lRigheDistintas = distinta.righeDistinta.toArray();
			for(int i = 0; i < lRigheDistintas.length; i++) {
				lRigheDistintas[i].setDistinta(null);
			}
			try {
				session.delete(distinta);
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
	
	public boolean refresh(Distinta distinta) throws PersistentException {
		try {
			Coedil99PersistentManager.instance().getSession().refresh(distinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(Distinta distinta) throws PersistentException {
		try {
			Coedil99PersistentManager.instance().getSession().evict(distinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Distinta loadDistintaByCriteria(DistintaCriteria distintaCriteria) {
		Distinta[] distintas = listDistintaByCriteria(distintaCriteria);
		if(distintas == null || distintas.length == 0) {
			return null;
		}
		return distintas[0];
	}
	
	public Distinta[] listDistintaByCriteria(DistintaCriteria distintaCriteria) {
		return distintaCriteria.listDistinta();
	}
}