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

import com.coedil99.modello_di_dominio.RDA;
import com.coedil99.modello_di_dominio.RDACriteria;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;



public interface RDADAO {
    public RDA loadRDAByORMID(int ID) throws PersistentException;

    public RDA getRDAByORMID(int ID) throws PersistentException;

    public RDA loadRDAByORMID(int ID, LockMode lockMode) throws PersistentException;

    public RDA getRDAByORMID(int ID, LockMode lockMode) throws PersistentException;

    public RDA loadRDAByORMID(PersistentSession session, int ID) throws PersistentException;

    public RDA getRDAByORMID(PersistentSession session, int ID) throws PersistentException;

    public RDA loadRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public RDA getRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public RDA[] listRDAByQuery(String condition, String orderBy) throws PersistentException;

    public RDA[] listRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryRDA(String condition, String orderBy) throws PersistentException;

    public java.util.List queryRDA(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateRDAByQuery(String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public RDA[] listRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public RDA[] listRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryRDA(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.List queryRDA(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public RDA loadRDAByQuery(String condition, String orderBy) throws PersistentException;

    public RDA loadRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public RDA loadRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public RDA loadRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public RDA createRDA();

    public boolean save(RDA rDA) throws PersistentException;

    public boolean delete(RDA rDA) throws PersistentException;

    public boolean deleteAndDissociate(RDA rDA) throws PersistentException;

    public boolean deleteAndDissociate(RDA rDA, PersistentSession session) throws PersistentException;

    public boolean refresh(RDA rDA) throws PersistentException;

    public boolean evict(RDA rDA) throws PersistentException;

    public RDA loadRDAByCriteria(RDACriteria rDACriteria);

    public RDA[] listRDAByCriteria(RDACriteria rDACriteria);
}
