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

public interface OrdineDAO {
	public Ordine loadOrdineByORMID(int ID) throws PersistentException;
	public Ordine getOrdineByORMID(int ID) throws PersistentException;
	public Ordine loadOrdineByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ordine getOrdineByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ordine loadOrdineByORMID(PersistentSession session, int ID) throws PersistentException;
	public Ordine getOrdineByORMID(PersistentSession session, int ID) throws PersistentException;
	public Ordine loadOrdineByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ordine getOrdineByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ordine[] listOrdineByQuery(String condition, String orderBy) throws PersistentException;
	public Ordine[] listOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryOrdine(String condition, String orderBy) throws PersistentException;
	public java.util.List queryOrdine(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateOrdineByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryOrdine(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryOrdine(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ordine loadOrdineByQuery(String condition, String orderBy) throws PersistentException;
	public Ordine loadOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ordine loadOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Ordine loadOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Ordine createOrdine();
	public boolean save(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException;
	public boolean delete(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException;
	public boolean deleteAndDissociate(com.coedil99.modello_di_dominio.Ordine ordine, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException;
	public boolean evict(com.coedil99.modello_di_dominio.Ordine ordine) throws PersistentException;
	public Ordine loadOrdineByCriteria(OrdineCriteria ordineCriteria);
	public Ordine[] listOrdineByCriteria(OrdineCriteria ordineCriteria);
}
