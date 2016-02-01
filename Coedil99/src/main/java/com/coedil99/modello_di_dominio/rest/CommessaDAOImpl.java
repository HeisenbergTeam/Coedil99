package com.coedil99.modello_di_dominio.rest;

import com.coedil99.modello_di_dominio.Commessa;
import com.coedil99.modello_di_dominio.CommessaCriteria;
import com.coedil99.modello_di_dominio.Pezzo;
import com.coedil99.modello_di_dominio.RestManager;
import com.coedil99.modello_di_dominio.dao.CommessaDAO;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 31/01/2016.
 */
public class CommessaDAOImpl implements CommessaDAO {
    public Commessa loadCommessaByORMID(int ID) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Commessa commessa = target.path("commessa").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Commessa.class);
        return commessa;
    }

    public Commessa getCommessaByORMID(int ID) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Commessa commessa = target.path("commessa").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Commessa.class);
        return commessa;
    }

    public Commessa loadCommessaByORMID(int ID, LockMode lockMode) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Commessa commessa = target.path("commessa").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Commessa.class);
        return commessa;
    }

    public Commessa getCommessaByORMID(int ID, LockMode lockMode) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Commessa commessa = target.path("commessa").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Commessa.class);
        return commessa;
    }

    public Commessa loadCommessaByORMID(PersistentSession session, int ID) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Commessa commessa = target.path("commessa").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Commessa.class);
        return commessa;
    }

    public Commessa getCommessaByORMID(PersistentSession session, int ID) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Commessa commessa = target.path("commessa").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Commessa.class);
        return commessa;
    }

    public Commessa loadCommessaByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Commessa commessa = target.path("commessa").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Commessa.class);
        return commessa;
    }

    public Commessa getCommessaByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Commessa commessa = target.path("commessa").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Commessa.class);
        return commessa;
    }

    public Commessa[] listCommessaByQuery(String condition, String orderBy) throws PersistentException {
        return new Commessa[0];
    }

    public Commessa[] listCommessaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Commessa[0];
    }

    public List queryCommessa(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryCommessa(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateCommessaByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateCommessaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Commessa[] listCommessaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return new Commessa[0];
    }

    public Commessa[] listCommessaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Commessa[0];
    }

    public List queryCommessa(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryCommessa(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateCommessaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateCommessaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Commessa loadCommessaByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Commessa loadCommessaByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Commessa loadCommessaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Commessa loadCommessaByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Commessa createCommessa() {
        return null;
    }

    public boolean save(Commessa commessa) throws PersistentException {
        return false;
    }

    public boolean delete(Commessa commessa) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Commessa commessa) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Commessa commessa, PersistentSession session) throws PersistentException {
        return false;
    }

    public boolean refresh(Commessa commessa) throws PersistentException {
        return false;
    }

    public boolean evict(Commessa commessa) throws PersistentException {
        return false;
    }

    public Commessa loadCommessaByCriteria(CommessaCriteria commessaCriteria) {
        return null;
    }

    public Commessa[] listCommessaByCriteria(CommessaCriteria commessaCriteria) {
        return new Commessa[0];
    }
}
