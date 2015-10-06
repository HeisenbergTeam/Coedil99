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

public interface CommessaDAO {
	public Commessa loadCommessaByORMID(int ID) throws PersistentException;
	public Commessa getCommessaByORMID(int ID) throws PersistentException;
	public Commessa loadCommessaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commessa getCommessaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commessa loadCommessaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Commessa getCommessaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Commessa loadCommessaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commessa getCommessaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commessa[] listCommessaByQuery(String condition, String orderBy) throws PersistentException;
	public Commessa[] listCommessaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryCommessa(String condition, String orderBy) throws PersistentException;
	public java.util.List queryCommessa(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateCommessaByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateCommessaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commessa[] listCommessaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Commessa[] listCommessaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryCommessa(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryCommessa(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateCommessaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateCommessaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commessa loadCommessaByQuery(String condition, String orderBy) throws PersistentException;
	public Commessa loadCommessaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commessa loadCommessaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Commessa loadCommessaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Commessa createCommessa();
	public boolean save(com.coedil99.modello_di_dominio.Commessa commessa) throws PersistentException;
	public boolean delete(com.coedil99.modello_di_dominio.Commessa commessa) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Commessa commessa) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Commessa commessa, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(com.coedil99.modello_di_dominio.Commessa commessa) throws PersistentException;
	public boolean evict(com.coedil99.modello_di_dominio.Commessa commessa) throws PersistentException;
	public Commessa loadCommessaByCriteria(CommessaCriteria commessaCriteria);
	public Commessa[] listCommessaByCriteria(CommessaCriteria commessaCriteria);
}
