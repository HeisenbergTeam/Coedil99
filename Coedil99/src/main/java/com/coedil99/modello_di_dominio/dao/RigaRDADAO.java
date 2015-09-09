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

import com.coedil99.modello_di_dominio.RigaRDA;
import com.coedil99.modello_di_dominio.RigaRDACriteria;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;



public interface RigaRDADAO {
    public RigaRDA loadRigaRDAByORMID(int ID) throws PersistentException;

    public RigaRDA getRigaRDAByORMID(int ID) throws PersistentException;

    public RigaRDA loadRigaRDAByORMID(int ID, LockMode lockMode) throws PersistentException;

    public RigaRDA getRigaRDAByORMID(int ID, LockMode lockMode) throws PersistentException;

    public RigaRDA loadRigaRDAByORMID(PersistentSession session, int ID) throws PersistentException;

    public RigaRDA getRigaRDAByORMID(PersistentSession session, int ID) throws PersistentException;

    public RigaRDA loadRigaRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public RigaRDA getRigaRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public RigaRDA[] listRigaRDAByQuery(String condition, String orderBy) throws PersistentException;

    public RigaRDA[] listRigaRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryRigaRDA(String condition, String orderBy) throws PersistentException;

    public java.util.List queryRigaRDA(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateRigaRDAByQuery(String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateRigaRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public RigaRDA[] listRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public RigaRDA[] listRigaRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryRigaRDA(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.List queryRigaRDA(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateRigaRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public RigaRDA loadRigaRDAByQuery(String condition, String orderBy) throws PersistentException;

    public RigaRDA loadRigaRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public RigaRDA loadRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public RigaRDA loadRigaRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public RigaRDA createRigaRDA();

    public boolean save(RigaRDA rigaRDA) throws PersistentException;

    public boolean delete(RigaRDA rigaRDA) throws PersistentException;

    public boolean deleteAndDissociate(RigaRDA rigaRDA) throws PersistentException;

    public boolean deleteAndDissociate(RigaRDA rigaRDA, PersistentSession session) throws PersistentException;

    public boolean refresh(RigaRDA rigaRDA) throws PersistentException;

    public boolean evict(RigaRDA rigaRDA) throws PersistentException;

    public RigaRDA loadRigaRDAByCriteria(RigaRDACriteria rigaRDACriteria);

    public RigaRDA[] listRigaRDAByCriteria(RigaRDACriteria rigaRDACriteria);
}
