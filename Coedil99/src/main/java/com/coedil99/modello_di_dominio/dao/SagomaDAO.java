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
package com.coedil99.modello_di_dominio.dao;

import com.coedil99.modello_di_dominio.Sagoma;
import com.coedil99.modello_di_dominio.SagomaCriteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public interface SagomaDAO {
	public Sagoma loadSagomaByORMID(int ID) throws PersistentException;
	public Sagoma getSagomaByORMID(int ID) throws PersistentException;
	public Sagoma loadSagomaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sagoma getSagomaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sagoma loadSagomaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Sagoma getSagomaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Sagoma loadSagomaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sagoma getSagomaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sagoma[] listSagomaByQuery(String condition, String orderBy) throws PersistentException;
	public Sagoma[] listSagomaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List querySagoma(String condition, String orderBy) throws PersistentException;
	public java.util.List querySagoma(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sagoma[] listSagomaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Sagoma[] listSagomaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List querySagoma(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List querySagoma(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sagoma loadSagomaByQuery(String condition, String orderBy) throws PersistentException;
	public Sagoma loadSagomaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sagoma loadSagomaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Sagoma loadSagomaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sagoma createSagoma();
	public boolean save(Sagoma sagoma) throws PersistentException;
	public boolean delete(Sagoma sagoma) throws PersistentException;
	public boolean deleteAndDissociate(Sagoma sagoma) throws PersistentException;
	public boolean deleteAndDissociate(Sagoma sagoma, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(Sagoma sagoma) throws PersistentException;
	public boolean evict(Sagoma sagoma) throws PersistentException;
	public Sagoma loadSagomaByCriteria(SagomaCriteria sagomaCriteria);
	public Sagoma[] listSagomaByCriteria(SagomaCriteria sagomaCriteria);
}
