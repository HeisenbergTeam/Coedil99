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
package modello_di_dominio.dao;

import org.orm.*;
import modello_di_dominio.*;

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
	public Pezzo[] listPezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Pezzo[] listPezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryPezzo(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryPezzo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo loadPezzoByQuery(String condition, String orderBy) throws PersistentException;
	public Pezzo loadPezzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo loadPezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Pezzo loadPezzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Pezzo createPezzo();
	public boolean save(modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public boolean delete(modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public boolean refresh(modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public boolean evict(modello_di_dominio.Pezzo pezzo) throws PersistentException;
	public Pezzo loadPezzoByCriteria(PezzoCriteria pezzoCriteria);
	public Pezzo[] listPezzoByCriteria(PezzoCriteria pezzoCriteria);
}
