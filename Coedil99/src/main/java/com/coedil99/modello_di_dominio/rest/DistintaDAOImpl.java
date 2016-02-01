package com.coedil99.modello_di_dominio.rest;

import com.coedil99.modello_di_dominio.Distinta;
import com.coedil99.modello_di_dominio.DistintaCriteria;
import com.coedil99.modello_di_dominio.dao.DistintaDAO;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 31/01/2016.
 */
public class DistintaDAOImpl implements DistintaDAO {
    public Distinta loadDistintaByORMID(int ID) throws PersistentException {
        return null;
    }

    public Distinta getDistintaByORMID(int ID) throws PersistentException {
        return null;
    }

    public Distinta loadDistintaByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Distinta getDistintaByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Distinta loadDistintaByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Distinta getDistintaByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Distinta loadDistintaByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Distinta getDistintaByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Distinta[] listDistintaByQuery(String condition, String orderBy) throws PersistentException {
        return new Distinta[0];
    }

    public Distinta[] listDistintaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Distinta[0];
    }

    public List queryDistinta(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryDistinta(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateDistintaByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateDistintaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return new Distinta[0];
    }

    public Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Distinta[0];
    }

    public List queryDistinta(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryDistinta(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateDistintaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Distinta loadDistintaByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Distinta loadDistintaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Distinta createDistinta() {
        return null;
    }

    public boolean save(Distinta distinta) throws PersistentException {
        return false;
    }

    public boolean delete(Distinta distinta) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Distinta distinta) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Distinta distinta, PersistentSession session) throws PersistentException {
        return false;
    }

    public boolean refresh(Distinta distinta) throws PersistentException {
        return false;
    }

    public boolean evict(Distinta distinta) throws PersistentException {
        return false;
    }

    public Distinta loadDistintaByCriteria(DistintaCriteria distintaCriteria) {
        return null;
    }

    public Distinta[] listDistintaByCriteria(DistintaCriteria distintaCriteria) {
        return new Distinta[0];
    }
}
