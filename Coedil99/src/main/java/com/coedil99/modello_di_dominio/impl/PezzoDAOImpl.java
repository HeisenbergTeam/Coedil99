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
package com.coedil99.modello_di_dominio.impl;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;
import com.coedil99.modello_di_dominio.*;

public class PezzoDAOImpl implements com.coedil99.modello_di_dominio.dao.PezzoDAO {
	public Pezzo loadPezzoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadPezzoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo getPezzoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getPezzoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo loadPezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadPezzoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo getPezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getPezzoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo loadPezzoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Pezzo) session.load(com.coedil99.modello_di_dominio.Pezzo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo getPezzoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Pezzo) session.get(com.coedil99.modello_di_dominio.Pezzo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo loadPezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pezzo) session.load(com.coedil99.modello_di_dominio.Pezzo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo getPezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pezzo) session.get(com.coedil99.modello_di_dominio.Pezzo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryPezzo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryPezzo(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryPezzo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryPezzo(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo[] listPezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listPezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo[] listPezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listPezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryPezzo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.Pezzo as Pezzo");
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
	
	public List queryPezzo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.Pezzo as Pezzo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pezzo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo[] listPezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPezzo(session, condition, orderBy);
			return (Pezzo[]) list.toArray(new Pezzo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo[] listPezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPezzo(session, condition, orderBy, lockMode);
			return (Pezzo[]) list.toArray(new Pezzo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo loadPezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadPezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo loadPezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadPezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo loadPezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Pezzo[] pezzos = listPezzoByQuery(session, condition, orderBy);
		if (pezzos != null && pezzos.length > 0)
			return pezzos[0];
		else
			return null;
	}
	
	public Pezzo loadPezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Pezzo[] pezzos = listPezzoByQuery(session, condition, orderBy, lockMode);
		if (pezzos != null && pezzos.length > 0)
			return pezzos[0];
		else
			return null;
	}
	
	public java.util.Iterator iteratePezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iteratePezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iteratePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iteratePezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iteratePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.Pezzo as Pezzo");
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
	
	public java.util.Iterator iteratePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.Pezzo as Pezzo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pezzo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo createPezzo() {
		return new com.coedil99.modello_di_dominio.Pezzo();
	}
	
	public boolean save(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().saveObject(pezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().deleteObject(pezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Pezzo pezzo)throws PersistentException {
		try {
			if (pezzo.getRigaRDA() != null) {
				pezzo.getRigaRDA().setPezzo(null);
			}
			
			return delete(pezzo);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Pezzo pezzo, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (pezzo.getRigaRDA() != null) {
				pezzo.getRigaRDA().setPezzo(null);
			}
			
			try {
				session.delete(pezzo);
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
	
	public boolean refresh(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().refresh(pezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().evict(pezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Pezzo loadPezzoByCriteria(PezzoCriteria pezzoCriteria) {
		Pezzo[] pezzos = listPezzoByCriteria(pezzoCriteria);
		if(pezzos == null || pezzos.length == 0) {
			return null;
		}
		return pezzos[0];
	}
	
	public Pezzo[] listPezzoByCriteria(PezzoCriteria pezzoCriteria) {
		return pezzoCriteria.listPezzo();
	}
}
