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

import com.coedil99.modello_di_dominio.DescrizionePezzo;
import com.coedil99.modello_di_dominio.DescrizionePezzoCriteria;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;


public interface DescrizionePezzoDAO {
    public DescrizionePezzo loadDescrizionePezzoByORMID(int ID) throws PersistentException;

    public DescrizionePezzo getDescrizionePezzoByORMID(int ID) throws PersistentException;

    public DescrizionePezzo loadDescrizionePezzoByORMID(int ID, LockMode lockMode) throws PersistentException;

    public DescrizionePezzo getDescrizionePezzoByORMID(int ID, LockMode lockMode) throws PersistentException;

    public DescrizionePezzo loadDescrizionePezzoByORMID(PersistentSession session, int ID) throws PersistentException;

    public DescrizionePezzo getDescrizionePezzoByORMID(PersistentSession session, int ID) throws PersistentException;

    public DescrizionePezzo loadDescrizionePezzoByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public DescrizionePezzo getDescrizionePezzoByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public DescrizionePezzo[] listDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException;

    public DescrizionePezzo[] listDescrizionePezzoByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryDescrizionePezzo(String condition, String orderBy) throws PersistentException;

    public java.util.List queryDescrizionePezzo(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateDescrizionePezzoByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public DescrizionePezzo[] listDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public DescrizionePezzo[] listDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryDescrizionePezzo(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.List queryDescrizionePezzo(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public DescrizionePezzo loadDescrizionePezzoByQuery(String condition, String orderBy) throws PersistentException;

    public DescrizionePezzo loadDescrizionePezzoByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public DescrizionePezzo loadDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public DescrizionePezzo loadDescrizionePezzoByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public DescrizionePezzo createDescrizionePezzo();

    public boolean save(DescrizionePezzo descrizionePezzo) throws PersistentException;

    public boolean delete(DescrizionePezzo descrizionePezzo) throws PersistentException;

    public boolean deleteAndDissociate(DescrizionePezzo descrizionePezzo) throws PersistentException;

    public boolean deleteAndDissociate(DescrizionePezzo descrizionePezzo, PersistentSession session) throws PersistentException;

    public boolean refresh(DescrizionePezzo descrizionePezzo) throws PersistentException;

    public boolean evict(DescrizionePezzo descrizionePezzo) throws PersistentException;

    public DescrizionePezzo loadDescrizionePezzoByCriteria(DescrizionePezzoCriteria descrizionePezzoCriteria);

    public DescrizionePezzo[] listDescrizionePezzoByCriteria(DescrizionePezzoCriteria descrizionePezzoCriteria);
}
