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

public interface PezzoDAO {
	public Pezzo loadPezzoByORMID(int ID) throws PersistentException;
	public Pezzo getPezzoByORMID(int ID) throws PersistentException;
	public Pezzo loadPezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo getPezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo loadPezzoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Pezzo getPezzoByORMID(PersistentSession session, int ID) throws PersistentException;
	public Pezzo loadPezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo getPezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo[] listPezzoByQuery(String condition, String orderBy) throws PersistentException;
	public Pezzo[] listPezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryPezzo(String condition, String orderBy) throws PersistentException;
	public java.util.List queryPezzo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iteratePezzoByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iteratePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo[] listPezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Pezzo[] listPezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryPezzo(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryPezzo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iteratePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iteratePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo loadPezzoByQuery(String condition, String orderBy) throws PersistentException;
	public Pezzo loadPezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo loadPezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Pezzo loadPezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo createPezzo();
	public boolean save(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public boolean delete(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Pezzo pezzo, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public boolean evict(com.coedil99.modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public Pezzo loadPezzoByCriteria(PezzoCriteria pezzoCriteria);
	public Pezzo[] listPezzoByCriteria(PezzoCriteria pezzoCriteria);
}
