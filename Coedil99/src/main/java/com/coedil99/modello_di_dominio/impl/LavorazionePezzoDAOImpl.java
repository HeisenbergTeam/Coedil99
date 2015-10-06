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

public class LavorazionePezzoDAOImpl implements com.coedil99.modello_di_dominio.dao.LavorazionePezzoDAO {
	public LavorazionePezzo loadLavorazionePezzoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadLavorazionePezzoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo getLavorazionePezzoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getLavorazionePezzoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo loadLavorazionePezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadLavorazionePezzoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo getLavorazionePezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getLavorazionePezzoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo loadLavorazionePezzoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (LavorazionePezzo) session.load(com.coedil99.modello_di_dominio.LavorazionePezzo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo getLavorazionePezzoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (LavorazionePezzo) session.get(com.coedil99.modello_di_dominio.LavorazionePezzo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo loadLavorazionePezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (LavorazionePezzo) session.load(com.coedil99.modello_di_dominio.LavorazionePezzo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo getLavorazionePezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (LavorazionePezzo) session.get(com.coedil99.modello_di_dominio.LavorazionePezzo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryLavorazionePezzo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryLavorazionePezzo(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryLavorazionePezzo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryLavorazionePezzo(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo[] listLavorazionePezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listLavorazionePezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo[] listLavorazionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listLavorazionePezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryLavorazionePezzo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.LavorazionePezzo as LavorazionePezzo");
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
	
	public List queryLavorazionePezzo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.LavorazionePezzo as LavorazionePezzo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("LavorazionePezzo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo[] listLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLavorazionePezzo(session, condition, orderBy);
			return (LavorazionePezzo[]) list.toArray(new LavorazionePezzo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo[] listLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLavorazionePezzo(session, condition, orderBy, lockMode);
			return (LavorazionePezzo[]) list.toArray(new LavorazionePezzo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo loadLavorazionePezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadLavorazionePezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo loadLavorazionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadLavorazionePezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo loadLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		LavorazionePezzo[] lavorazionePezzos = listLavorazionePezzoByQuery(session, condition, orderBy);
		if (lavorazionePezzos != null && lavorazionePezzos.length > 0)
			return lavorazionePezzos[0];
		else
			return null;
	}
	
	public LavorazionePezzo loadLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		LavorazionePezzo[] lavorazionePezzos = listLavorazionePezzoByQuery(session, condition, orderBy, lockMode);
		if (lavorazionePezzos != null && lavorazionePezzos.length > 0)
			return lavorazionePezzos[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateLavorazionePezzoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateLavorazionePezzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateLavorazionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateLavorazionePezzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.LavorazionePezzo as LavorazionePezzo");
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
	
	public java.util.Iterator iterateLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.LavorazionePezzo as LavorazionePezzo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("LavorazionePezzo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo createLavorazionePezzo() {
		return new com.coedil99.modello_di_dominio.LavorazionePezzo();
	}
	
	public boolean save(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().saveObject(lavorazionePezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().deleteObject(lavorazionePezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo)throws PersistentException {
		try {
			if (lavorazionePezzo.getSagoma() != null) {
				lavorazionePezzo.getSagoma().setLavorazionePezzo(null);
			}
			
			return delete(lavorazionePezzo);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (lavorazionePezzo.getSagoma() != null) {
				lavorazionePezzo.getSagoma().setLavorazionePezzo(null);
			}
			
			try {
				session.delete(lavorazionePezzo);
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
	
	public boolean refresh(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().refresh(lavorazionePezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().evict(lavorazionePezzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public LavorazionePezzo loadLavorazionePezzoByCriteria(LavorazionePezzoCriteria lavorazionePezzoCriteria) {
		LavorazionePezzo[] lavorazionePezzos = listLavorazionePezzoByCriteria(lavorazionePezzoCriteria);
		if(lavorazionePezzos == null || lavorazionePezzos.length == 0) {
			return null;
		}
		return lavorazionePezzos[0];
	}
	
	public LavorazionePezzo[] listLavorazionePezzoByCriteria(LavorazionePezzoCriteria lavorazionePezzoCriteria) {
		return lavorazionePezzoCriteria.listLavorazionePezzo();
	}
}
