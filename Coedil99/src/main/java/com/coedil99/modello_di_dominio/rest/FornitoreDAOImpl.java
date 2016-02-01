package com.coedil99.modello_di_dominio.rest;

import com.coedil99.modello_di_dominio.Fornitore;
import com.coedil99.modello_di_dominio.FornitoreCriteria;
import com.coedil99.modello_di_dominio.dao.FornitoreDAO;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 01/02/2016.
 */
public class FornitoreDAOImpl implements FornitoreDAO {
    public Fornitore loadFornitoreByORMID(int ID) throws PersistentException {
        return null;
    }

    public Fornitore getFornitoreByORMID(int ID) throws PersistentException {
        return null;
    }

    public Fornitore loadFornitoreByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Fornitore getFornitoreByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Fornitore loadFornitoreByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Fornitore getFornitoreByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Fornitore loadFornitoreByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Fornitore getFornitoreByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Fornitore[] listFornitoreByQuery(String condition, String orderBy) throws PersistentException {
        return new Fornitore[0];
    }

    public Fornitore[] listFornitoreByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Fornitore[0];
    }

    public List queryFornitore(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryFornitore(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateFornitoreByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateFornitoreByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Fornitore[] listFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return new Fornitore[0];
    }

    public Fornitore[] listFornitoreByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Fornitore[0];
    }

    public List queryFornitore(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryFornitore(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateFornitoreByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Fornitore loadFornitoreByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Fornitore loadFornitoreByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Fornitore loadFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Fornitore loadFornitoreByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Fornitore createFornitore() {
        return null;
    }

    public boolean save(Fornitore fornitore) throws PersistentException {
        return false;
    }

    public boolean delete(Fornitore fornitore) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Fornitore fornitore) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Fornitore fornitore, PersistentSession session) throws PersistentException {
        return false;
    }

    public boolean refresh(Fornitore fornitore) throws PersistentException {
        return false;
    }

    public boolean evict(Fornitore fornitore) throws PersistentException {
        return false;
    }

    public Fornitore loadFornitoreByCriteria(FornitoreCriteria fornitoreCriteria) {
        return null;
    }

    public Fornitore[] listFornitoreByCriteria(FornitoreCriteria fornitoreCriteria) {
        return new Fornitore[0];
    }
}
