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

public interface LavorazionePezzoDAO {
	public LavorazionePezzo loadLavorazionePezzoByORMID(int ID) throws PersistentException;
	public LavorazionePezzo getLavorazionePezzoByORMID(int ID) throws PersistentException;
	public LavorazionePezzo loadLavorazionePezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public LavorazionePezzo getLavorazionePezzoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public LavorazionePezzo loadLavorazionePezzoByORMID(PersistentSession session, int ID) throws PersistentException;
	public LavorazionePezzo getLavorazionePezzoByORMID(PersistentSession session, int ID) throws PersistentException;
	public LavorazionePezzo loadLavorazionePezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public LavorazionePezzo getLavorazionePezzoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public LavorazionePezzo[] listLavorazionePezzoByQuery(String condition, String orderBy) throws PersistentException;
	public LavorazionePezzo[] listLavorazionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryLavorazionePezzo(String condition, String orderBy) throws PersistentException;
	public java.util.List queryLavorazionePezzo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateLavorazionePezzoByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateLavorazionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public LavorazionePezzo[] listLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public LavorazionePezzo[] listLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryLavorazionePezzo(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryLavorazionePezzo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public LavorazionePezzo loadLavorazionePezzoByQuery(String condition, String orderBy) throws PersistentException;
	public LavorazionePezzo loadLavorazionePezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public LavorazionePezzo loadLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public LavorazionePezzo loadLavorazionePezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public LavorazionePezzo createLavorazionePezzo();
	public boolean save(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException;
	public boolean delete(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException;
	public boolean evict(com.coedil99.modello_di_dominio.LavorazionePezzo lavorazionePezzo) throws PersistentException;
	public LavorazionePezzo loadLavorazionePezzoByCriteria(LavorazionePezzoCriteria lavorazionePezzoCriteria);
	public LavorazionePezzo[] listLavorazionePezzoByCriteria(LavorazionePezzoCriteria lavorazionePezzoCriteria);
}
