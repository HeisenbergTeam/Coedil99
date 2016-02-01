package com.coedil99.modello_di_dominio.rest;

import com.coedil99.modello_di_dominio.RDA;
import com.coedil99.modello_di_dominio.RDACriteria;
import com.coedil99.modello_di_dominio.dao.RDADAO;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 01/02/2016.
 */
public class RDADAOImpl implements RDADAO {
    public RDA loadRDAByORMID(int ID) throws PersistentException {
        return null;
    }

    public RDA getRDAByORMID(int ID) throws PersistentException {
        return null;
    }

    public RDA loadRDAByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public RDA getRDAByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public RDA loadRDAByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public RDA getRDAByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public RDA loadRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public RDA getRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public RDA[] listRDAByQuery(String condition, String orderBy) throws PersistentException {
        return new RDA[0];
    }

    public RDA[] listRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new RDA[0];
    }

    public List queryRDA(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryRDA(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateRDAByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public RDA[] listRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return new RDA[0];
    }

    public RDA[] listRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new RDA[0];
    }

    public List queryRDA(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryRDA(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public RDA loadRDAByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public RDA loadRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public RDA loadRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public RDA loadRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public RDA createRDA() {
        return null;
    }

    public boolean save(RDA rDA) throws PersistentException {
        return false;
    }

    public boolean delete(RDA rDA) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(RDA rDA) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(RDA rDA, PersistentSession session) throws PersistentException {
        return false;
    }

    public boolean refresh(RDA rDA) throws PersistentException {
        return false;
    }

    public boolean evict(RDA rDA) throws PersistentException {
        return false;
    }

    public RDA loadRDAByCriteria(RDACriteria rDACriteria) {
        return null;
    }

    public RDA[] listRDAByCriteria(RDACriteria rDACriteria) {
        return new RDA[0];
    }
}
