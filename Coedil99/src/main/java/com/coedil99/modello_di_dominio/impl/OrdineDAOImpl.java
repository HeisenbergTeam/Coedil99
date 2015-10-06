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

public class OrdineDAOImpl implements com.coedil99.modello_di_dominio.dao.OrdineDAO {
	public Ordine loadOrdineByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadOrdineByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine getOrdineByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getOrdineByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine loadOrdineByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadOrdineByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine getOrdineByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getOrdineByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine loadOrdineByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Ordine) session.load(com.coedil99.modello_di_dominio.Ordine.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine getOrdineByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Ordine) session.get(com.coedil99.modello_di_dominio.Ordine.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine loadOrdineByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ordine) session.load(com.coedil99.modello_di_dominio.Ordine.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine getOrdineByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ordine) session.get(com.coedil99.modello_di_dominio.Ordine.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryOrdine(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryOrdine(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryOrdine(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryOrdine(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine[] listOrdineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine[] listOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listOrdineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryOrdine(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.Ordine as Ordine");
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
	
	public List queryOrdine(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.Ordine as Ordine");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ordine", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryOrdine(session, condition, orderBy);
			return (Ordine[]) list.toArray(new Ordine[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryOrdine(session, condition, orderBy, lockMode);
			return (Ordine[]) list.toArray(new Ordine[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine loadOrdineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine loadOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadOrdineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine loadOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ordine[] ordines = listOrdineByQuery(session, condition, orderBy);
		if (ordines != null && ordines.length > 0)
			return ordines[0];
		else
			return null;
	}
	
	public Ordine loadOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ordine[] ordines = listOrdineByQuery(session, condition, orderBy, lockMode);
		if (ordines != null && ordines.length > 0)
			return ordines[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateOrdineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateOrdineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.Ordine as Ordine");
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
	
	public java.util.Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.Ordine as Ordine");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ordine", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine createOrdine() {
		return new com.coedil99.modello_di_dominio.Ordine();
	}
	
	public boolean save(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().saveObject(ordine);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().deleteObject(ordine);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Ordine ordine)throws PersistentException {
		try {
			if (ordine.getDestinazione() != null) {
				ordine.getDestinazione().setOrdine(null);
			}
			
			com.coedil99.modello_di_dominio.Commessa[] lCommesses = ordine.commesse.toArray();
			for(int i = 0; i < lCommesses.length; i++) {
				lCommesses[i].setOrdine(null);
			}
			return delete(ordine);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Ordine ordine, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (ordine.getDestinazione() != null) {
				ordine.getDestinazione().setOrdine(null);
			}
			
			com.coedil99.modello_di_dominio.Commessa[] lCommesses = ordine.commesse.toArray();
			for(int i = 0; i < lCommesses.length; i++) {
				lCommesses[i].setOrdine(null);
			}
			try {
				session.delete(ordine);
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
	
	public boolean refresh(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().refresh(ordine);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().evict(ordine);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Ordine loadOrdineByCriteria(OrdineCriteria ordineCriteria) {
		Ordine[] ordines = listOrdineByCriteria(ordineCriteria);
		if(ordines == null || ordines.length == 0) {
			return null;
		}
		return ordines[0];
	}
	
	public Ordine[] listOrdineByCriteria(OrdineCriteria ordineCriteria) {
		return ordineCriteria.listOrdine();
	}
}
