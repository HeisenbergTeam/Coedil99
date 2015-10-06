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

public interface RigaDistintaDAO {
	public RigaDistinta loadRigaDistintaByORMID(int ID) throws PersistentException;
	public RigaDistinta getRigaDistintaByORMID(int ID) throws PersistentException;
	public RigaDistinta loadRigaDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaDistinta getRigaDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaDistinta loadRigaDistintaByORMID(PersistentSession session, int ID) throws PersistentException;
	public RigaDistinta getRigaDistintaByORMID(PersistentSession session, int ID) throws PersistentException;
	public RigaDistinta loadRigaDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaDistinta getRigaDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaDistinta[] listRigaDistintaByQuery(String condition, String orderBy) throws PersistentException;
	public RigaDistinta[] listRigaDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryRigaDistinta(String condition, String orderBy) throws PersistentException;
	public java.util.List queryRigaDistinta(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateRigaDistintaByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateRigaDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaDistinta[] listRigaDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public RigaDistinta[] listRigaDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryRigaDistinta(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryRigaDistinta(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateRigaDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateRigaDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaDistinta loadRigaDistintaByQuery(String condition, String orderBy) throws PersistentException;
	public RigaDistinta loadRigaDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaDistinta loadRigaDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public RigaDistinta loadRigaDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public RigaDistinta createRigaDistinta();
	public boolean save(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException;
	public boolean delete(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException;
	public boolean evict(com.coedil99.modello_di_dominio.RigaDistinta rigaDistinta) throws PersistentException;
	public RigaDistinta loadRigaDistintaByCriteria(RigaDistintaCriteria rigaDistintaCriteria);
	public RigaDistinta[] listRigaDistintaByCriteria(RigaDistintaCriteria rigaDistintaCriteria);
}
