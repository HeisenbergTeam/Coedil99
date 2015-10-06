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
package com.coedil99.modello_di_dominio.dao;

import org.orm.*;
import org.hibernate.LockMode;
import com.coedil99.modello_di_dominio.*;

public interface RigaRDADAO {
	public RigaRDA loadRigaRDAByORMID(int ID) throws PersistentException;
	public RigaRDA getRigaRDAByORMID(int ID) throws PersistentException;
	public RigaRDA loadRigaRDAByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaRDA getRigaRDAByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaRDA loadRigaRDAByORMID(PersistentSession session, int ID) throws PersistentException;
	public RigaRDA getRigaRDAByORMID(PersistentSession session, int ID) throws PersistentException;
	public RigaRDA loadRigaRDAByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaRDA getRigaRDAByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaRDA[] listRigaRDAByQuery(String condition, String orderBy) throws PersistentException;
	public RigaRDA[] listRigaRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryRigaRDA(String condition, String orderBy) throws PersistentException;
	public java.util.List queryRigaRDA(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateRigaRDAByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateRigaRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaRDA[] listRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public RigaRDA[] listRigaRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryRigaRDA(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryRigaRDA(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateRigaRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaRDA loadRigaRDAByQuery(String condition, String orderBy) throws PersistentException;
	public RigaRDA loadRigaRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaRDA loadRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public RigaRDA loadRigaRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaRDA createRigaRDA();
	public boolean save(com.coedil99.modello_di_dominio.RigaRDA rigaRDA) throws PersistentException;
	public boolean delete(com.coedil99.modello_di_dominio.RigaRDA rigaRDA) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.RigaRDA rigaRDA) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.RigaRDA rigaRDA, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(com.coedil99.modello_di_dominio.RigaRDA rigaRDA) throws PersistentException;
	public boolean evict(com.coedil99.modello_di_dominio.RigaRDA rigaRDA) throws PersistentException;
	public RigaRDA loadRigaRDAByCriteria(RigaRDACriteria rigaRDACriteria);
	public RigaRDA[] listRigaRDAByCriteria(RigaRDACriteria rigaRDACriteria);
}
