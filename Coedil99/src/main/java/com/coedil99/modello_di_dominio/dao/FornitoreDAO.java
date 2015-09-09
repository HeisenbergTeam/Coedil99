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

import com.coedil99.modello_di_dominio.Fornitore;
import com.coedil99.modello_di_dominio.FornitoreCriteria;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public interface FornitoreDAO {
    public Fornitore loadFornitoreByORMID(int ID) throws PersistentException;

    public Fornitore getFornitoreByORMID(int ID) throws PersistentException;

    public Fornitore loadFornitoreByORMID(int ID, LockMode lockMode) throws PersistentException;

    public Fornitore getFornitoreByORMID(int ID, LockMode lockMode) throws PersistentException;

    public Fornitore loadFornitoreByORMID(PersistentSession session, int ID) throws PersistentException;

    public Fornitore getFornitoreByORMID(PersistentSession session, int ID) throws PersistentException;

    public Fornitore loadFornitoreByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public Fornitore getFornitoreByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public Fornitore[] listFornitoreByQuery(String condition, String orderBy) throws PersistentException;

    public Fornitore[] listFornitoreByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryFornitore(String condition, String orderBy) throws PersistentException;

    public java.util.List queryFornitore(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateFornitoreByQuery(String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateFornitoreByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public Fornitore[] listFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public Fornitore[] listFornitoreByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryFornitore(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.List queryFornitore(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateFornitoreByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public Fornitore loadFornitoreByQuery(String condition, String orderBy) throws PersistentException;

    public Fornitore loadFornitoreByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public Fornitore loadFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public Fornitore loadFornitoreByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public Fornitore createFornitore();

    public boolean save(Fornitore fornitore) throws PersistentException;

    public boolean delete(Fornitore fornitore) throws PersistentException;

    public boolean deleteAndDissociate(Fornitore fornitore) throws PersistentException;

    public boolean deleteAndDissociate(Fornitore fornitore, PersistentSession session) throws PersistentException;

    public boolean refresh(Fornitore fornitore) throws PersistentException;

    public boolean evict(Fornitore fornitore) throws PersistentException;

    public Fornitore loadFornitoreByCriteria(FornitoreCriteria fornitoreCriteria);

    public Fornitore[] listFornitoreByCriteria(FornitoreCriteria fornitoreCriteria);
}
