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

public interface DescrizionePezzoDAO {
	public DescrizionePezzo loadDescrizionePezzoByORMID(int ID) throws PersistentException;
	public DescrizionePezzo getDescrizionePezzoByORMID(int ID) throws PersistentException;
	public DescrizionePezzo loadDescrizionePezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public DescrizionePezzo getDescrizionePezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public DescrizionePezzo loadDescrizionePezzoByORMID(PersistentSession session, int ID) throws PersistentException;
	public DescrizionePezzo getDescrizionePezzoByORMID(PersistentSession session, int ID) throws PersistentException;
	public DescrizionePezzo loadDescrizionePezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public DescrizionePezzo getDescrizionePezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public DescrizionePezzo[] listDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException;
	public DescrizionePezzo[] listDescrizionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryDescrizionePezzo(String condition, String orderBy) throws PersistentException;
	public java.util.List queryDescrizionePezzo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateDescrizionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public DescrizionePezzo[] listDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public DescrizionePezzo[] listDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryDescrizionePezzo(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryDescrizionePezzo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public DescrizionePezzo loadDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException;
	public DescrizionePezzo loadDescrizionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public DescrizionePezzo loadDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public DescrizionePezzo loadDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public DescrizionePezzo createDescrizionePezzo();
	public boolean save(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException;
	public boolean delete(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException;
	public boolean evict(com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo) throws PersistentException;
	public DescrizionePezzo loadDescrizionePezzoByCriteria(DescrizionePezzoCriteria descrizionePezzoCriteria);
	public DescrizionePezzo[] listDescrizionePezzoByCriteria(DescrizionePezzoCriteria descrizionePezzoCriteria);
}
