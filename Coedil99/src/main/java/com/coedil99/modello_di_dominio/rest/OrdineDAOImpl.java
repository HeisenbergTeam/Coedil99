package com.coedil99.modello_di_dominio.rest;

import com.coedil99.modello_di_dominio.Ordine;
import com.coedil99.modello_di_dominio.OrdineCriteria;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 01/02/2016.
 */
public class OrdineDAOImpl implements OrdineDAO {
    public Ordine loadOrdineByORMID(int ID) throws PersistentException {
        return null;
    }

    public Ordine getOrdineByORMID(int ID) throws PersistentException {
        return null;
    }

    public Ordine loadOrdineByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Ordine getOrdineByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Ordine loadOrdineByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Ordine getOrdineByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Ordine loadOrdineByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Ordine getOrdineByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Ordine[] listOrdineByQuery(String condition, String orderBy) throws PersistentException {
        return new Ordine[0];
    }

    public Ordine[] listOrdineByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Ordine[0];
    }

    public List queryOrdine(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryOrdine(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateOrdineByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateOrdineByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return new Ordine[0];
    }

    public Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Ordine[0];
    }

    public List queryOrdine(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryOrdine(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Ordine loadOrdineByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Ordine loadOrdineByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Ordine loadOrdineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Ordine loadOrdineByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Ordine createOrdine() {
        return null;
    }

    public boolean save(Ordine ordine) throws PersistentException {
        return false;
    }

    public boolean delete(Ordine ordine) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Ordine ordine) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Ordine ordine, PersistentSession session) throws PersistentException {
        return false;
    }

    public boolean refresh(Ordine ordine) throws PersistentException {
        return false;
    }

    public boolean evict(Ordine ordine) throws PersistentException {
        return false;
    }

    public Ordine loadOrdineByCriteria(OrdineCriteria ordineCriteria) {
        return null;
    }

    public Ordine[] listOrdineByCriteria(OrdineCriteria ordineCriteria) {
        return new Ordine[0];
    }
}
