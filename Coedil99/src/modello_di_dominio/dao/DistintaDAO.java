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

public interface DistintaDAO {
	public Distinta loadDistintaByORMID(int ID) throws PersistentException;
	public Distinta getDistintaByORMID(int ID) throws PersistentException;
	public Distinta loadDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Distinta getDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Distinta loadDistintaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Distinta getDistintaByORMID(PersistentSession session, int ID) throws PersistentException;
	public Distinta loadDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Distinta getDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public Distinta[] listDistintaByQuery(String condition, String orderBy) throws PersistentException;
	public Distinta[] listDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryDistinta(String condition, String orderBy) throws PersistentException;
	public java.util.List queryDistinta(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryDistinta(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryDistinta(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Distinta loadDistintaByQuery(String condition, String orderBy) throws PersistentException;
	public Distinta loadDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Distinta createDistinta();
	public boolean save(modello_di_dominio.Distinta distinta) throws PersistentException;
	public boolean delete(modello_di_dominio.Distinta distinta) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Distinta distinta) throws PersistentException;
	public boolean deleteAndDissociate(modello_di_dominio.Distinta distinta, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(modello_di_dominio.Distinta distinta) throws PersistentException;
	public boolean evict(modello_di_dominio.Distinta distinta) throws PersistentException;
	public Distinta loadDistintaByCriteria(DistintaCriteria distintaCriteria);
	public Distinta[] listDistintaByCriteria(DistintaCriteria distintaCriteria);
}
