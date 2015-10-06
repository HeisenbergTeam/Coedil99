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

public class RigaDistintaDAOImpl implements com.coedil99.modello_di_dominio.dao.RigaDistintaDAO {
	public RigaDistinta loadRigaDistintaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadRigaDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta getRigaDistintaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getRigaDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta loadRigaDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadRigaDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta getRigaDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return getRigaDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta loadRigaDistintaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (RigaDistinta) session.load(com.coedil99.modello_di_dominio.RigaDistinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta getRigaDistintaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (RigaDistinta) session.get(com.coedil99.modello_di_dominio.RigaDistinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta loadRigaDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RigaDistinta) session.load(com.coedil99.modello_di_dominio.RigaDistinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta getRigaDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RigaDistinta) session.get(com.coedil99.modello_di_dominio.RigaDistinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryRigaDistinta(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryRigaDistinta(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryRigaDistinta(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return queryRigaDistinta(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta[] listRigaDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listRigaDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta[] listRigaDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return listRigaDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryRigaDistinta(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.RigaDistinta as RigaDistinta");
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
	
	public List queryRigaDistinta(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.RigaDistinta as RigaDistinta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("RigaDistinta", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta[] listRigaDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRigaDistinta(session, condition, orderBy);
			return (RigaDistinta[]) list.toArray(new RigaDistinta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta[] listRigaDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRigaDistinta(session, condition, orderBy, lockMode);
			return (RigaDistinta[]) list.toArray(new RigaDistinta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta loadRigaDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadRigaDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta loadRigaDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return loadRigaDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta loadRigaDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		RigaDistinta[] rigaDistintas = listRigaDistintaByQuery(session, condition, orderBy);
		if (rigaDistintas != null && rigaDistintas.length > 0)
			return rigaDistintas[0];
		else
			return null;
	}
	
	public RigaDistinta loadRigaDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		RigaDistinta[] rigaDistintas = listRigaDistintaByQuery(session, condition, orderBy, lockMode);
		if (rigaDistintas != null && rigaDistintas.length > 0)
			return rigaDistintas[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateRigaDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateRigaDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateRigaDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession();
			return iterateRigaDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateRigaDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.RigaDistinta as RigaDistinta");
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
	
	public java.util.Iterator iterateRigaDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.coedil99.modello_di_dominio.RigaDistinta as RigaDistinta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("RigaDistinta", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta createRigaDistinta() {
		return new com.coedil99.modello_di_dominio.RigaDistinta();
	}
	
	public boolean save(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().saveObject(rigaDistinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().deleteObject(rigaDistinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta)throws PersistentException {
		try {
			if (rigaDistinta.getDistinta() != null) {
				rigaDistinta.getDistinta().righeDistinta.remove(rigaDistinta);
			}
			
			return delete(rigaDistinta);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (rigaDistinta.getDistinta() != null) {
				rigaDistinta.getDistinta().righeDistinta.remove(rigaDistinta);
			}
			
			try {
				session.delete(rigaDistinta);
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
	
	public boolean refresh(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().refresh(rigaDistinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException {
		try {
			com.coedil99.modello_di_dominio.Coedil99PersistentManager.instance().getSession().evict(rigaDistinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public RigaDistinta loadRigaDistintaByCriteria(RigaDistintaCriteria rigaDistintaCriteria) {
		RigaDistinta[] rigaDistintas = listRigaDistintaByCriteria(rigaDistintaCriteria);
		if(rigaDistintas == null || rigaDistintas.length == 0) {
			return null;
		}
		return rigaDistintas[0];
	}
	
	public RigaDistinta[] listRigaDistintaByCriteria(RigaDistintaCriteria rigaDistintaCriteria) {
		return rigaDistintaCriteria.listRigaDistinta();
	}
}
