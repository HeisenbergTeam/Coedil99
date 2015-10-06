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

public class DescrizionePezzoDAOImpl implements com.coedil99.modello_di_dominio.dao.DescrizionePezzoDAO {
	public DescrizionePezzo loadDescrizionePezzoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadDescrizionePezzoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo getDescrizionePezzoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getDescrizionePezzoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo loadDescrizionePezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadDescrizionePezzoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo getDescrizionePezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getDescrizionePezzoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo loadDescrizionePezzoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (DescrizionePezzo) session.load(com.coedil99.modello_di_dominio.DescrizionePezzo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo getDescrizionePezzoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (DescrizionePezzo) session.get(com.coedil99.modello_di_dominio.DescrizionePezzo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo loadDescrizionePezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (DescrizionePezzo) session.load(com.coedil99.modello_di_dominio.DescrizionePezzo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo getDescrizionePezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (DescrizionePezzo) session.get(com.coedil99.modello_di_dominio.DescrizionePezzo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryDescrizionePezzo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryDescrizionePezzo(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryDescrizionePezzo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryDescrizionePezzo(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo[] listDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listDescrizionePezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo[] listDescrizionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listDescrizionePezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryDescrizionePezzo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.DescrizionePezzo as DescrizionePezzo");
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
	
	public List queryDescrizionePezzo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.DescrizionePezzo as DescrizionePezzo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("DescrizionePezzo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo[] listDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDescrizionePezzo(session, condition, orderBy);
			return (DescrizionePezzo[]) list.toArray(new DescrizionePezzo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo[] listDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDescrizionePezzo(session, condition, orderBy, lockMode);
			return (DescrizionePezzo[]) list.toArray(new DescrizionePezzo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo loadDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadDescrizionePezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo loadDescrizionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadDescrizionePezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo loadDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		DescrizionePezzo[] descrizionePezzos = listDescrizionePezzoByQuery(session, condition, orderBy);
		if (descrizionePezzos != null && descrizionePezzos.length > 0)
			return descrizionePezzos[0];
		else
			return null;
	}
	
	public DescrizionePezzo loadDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		DescrizionePezzo[] descrizionePezzos = listDescrizionePezzoByQuery(session, condition, orderBy, lockMode);
		if (descrizionePezzos != null && descrizionePezzos.length > 0)
			return descrizionePezzos[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateDescrizionePezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateDescrizionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateDescrizionePezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.DescrizionePezzo as DescrizionePezzo");
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
	
	public java.util.Iterator iterateDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.DescrizionePezzo as DescrizionePezzo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("DescrizionePezzo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo createDescrizionePezzo() {
		return new com.coedil99.modello_di_dominio.DescrizionePezzo();
	}
	
	public boolean save(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().saveObject(descrizionePezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().deleteObject(descrizionePezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo)throws PersistentException {
		try {
			if (descrizionePezzo.getFornitore() != null) {
				descrizionePezzo.getFornitore().descrizionePezzo.remove(descrizionePezzo);
			}
			
			return delete(descrizionePezzo);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (descrizionePezzo.getFornitore() != null) {
				descrizionePezzo.getFornitore().descrizionePezzo.remove(descrizionePezzo);
			}
			
			try {
				session.delete(descrizionePezzo);
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
	
	public boolean refresh(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().refresh(descrizionePezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().evict(descrizionePezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public DescrizionePezzo loadDescrizionePezzoByCriteria(DescrizionePezzoCriteria descrizionePezzoCriteria) {
		DescrizionePezzo[] descrizionePezzos = listDescrizionePezzoByCriteria(descrizionePezzoCriteria);
		if(descrizionePezzos == null || descrizionePezzos.length == 0) {
			return null;
		}
		return descrizionePezzos[0];
	}
	
	public DescrizionePezzo[] listDescrizionePezzoByCriteria(DescrizionePezzoCriteria descrizionePezzoCriteria) {
		return descrizionePezzoCriteria.listDescrizionePezzo();
	}
}
