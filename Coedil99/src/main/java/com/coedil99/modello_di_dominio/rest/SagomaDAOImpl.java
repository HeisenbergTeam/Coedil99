package com.coedil99.modello_di_dominio.rest;

import com.coedil99.modello_di_dominio.Sagoma;
import com.coedil99.modello_di_dominio.SagomaCriteria;
import com.coedil99.modello_di_dominio.dao.SagomaDAO;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 01/02/2016.
 */
public class SagomaDAOImpl implements SagomaDAO {
    public Sagoma loadSagomaByORMID(int ID) throws PersistentException {
        return null;
    }

    public Sagoma getSagomaByORMID(int ID) throws PersistentException {
        return null;
    }

    public Sagoma loadSagomaByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Sagoma getSagomaByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Sagoma loadSagomaByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Sagoma getSagomaByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Sagoma loadSagomaByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Sagoma getSagomaByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Sagoma[] listSagomaByQuery(String condition, String orderBy) throws PersistentException {
        return new Sagoma[0];
    }

    public Sagoma[] listSagomaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Sagoma[0];
    }

    public List querySagoma(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List querySagoma(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateSagomaByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateSagomaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Sagoma[] listSagomaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return new Sagoma[0];
    }

    public Sagoma[] listSagomaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Sagoma[0];
    }

    public List querySagoma(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List querySagoma(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateSagomaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateSagomaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Sagoma loadSagomaByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Sagoma loadSagomaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Sagoma loadSagomaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Sagoma loadSagomaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Sagoma createSagoma() {
        return null;
    }

    public boolean save(Sagoma sagoma) throws PersistentException {
        return false;
    }

    public boolean delete(Sagoma sagoma) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Sagoma sagoma) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Sagoma sagoma, PersistentSession session) throws PersistentException {
        return false;
    }

    public boolean refresh(Sagoma sagoma) throws PersistentException {
        return false;
    }

    public boolean evict(Sagoma sagoma) throws PersistentException {
        return false;
    }

    public Sagoma loadSagomaByCriteria(SagomaCriteria sagomaCriteria) {
        return null;
    }

    public Sagoma[] listSagomaByCriteria(SagomaCriteria sagomaCriteria) {
        return new Sagoma[0];
    }
}
