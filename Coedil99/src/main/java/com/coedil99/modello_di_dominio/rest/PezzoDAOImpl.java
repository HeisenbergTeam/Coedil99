package com.coedil99.modello_di_dominio.rest;

import com.coedil99.modello_di_dominio.Pezzo;
import com.coedil99.modello_di_dominio.PezzoCriteria;
import com.coedil99.modello_di_dominio.RestManager;
import com.coedil99.modello_di_dominio.dao.PezzoDAO;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 31/01/2016.
 */
public class PezzoDAOImpl implements PezzoDAO {
    public Pezzo loadPezzoByORMID(int ID) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Pezzo pezzo = target.path("pezzo").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Pezzo.class);
        return pezzo;
    }

    public Pezzo getPezzoByORMID(int ID) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Pezzo pezzo = target.path("pezzo").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Pezzo.class);
        return pezzo;
    }

    public Pezzo loadPezzoByORMID(int ID, LockMode lockMode) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Pezzo pezzo = target.path("pezzo").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Pezzo.class);
        return pezzo;
    }

    public Pezzo getPezzoByORMID(int ID, LockMode lockMode) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Pezzo pezzo = target.path("pezzo").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Pezzo.class);
        return pezzo;
    }

    public Pezzo loadPezzoByORMID(PersistentSession session, int ID) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Pezzo pezzo = target.path("pezzo").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Pezzo.class);
        return pezzo;
    }

    public Pezzo getPezzoByORMID(PersistentSession session, int ID) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Pezzo pezzo = target.path("pezzo").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Pezzo.class);
        return pezzo;
    }

    public Pezzo loadPezzoByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Pezzo pezzo = target.path("pezzo").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Pezzo.class);
        return pezzo;
    }

    public Pezzo getPezzoByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        WebTarget target = RestManager.instance().getTarget();
        Pezzo pezzo = target.path("pezzo").path(String.valueOf(ID)).request().accept(MediaType.APPLICATION_JSON)
                .get(Pezzo.class);
        return pezzo;
    }

    public Pezzo[] listPezzoByQuery(String condition, String orderBy) throws PersistentException {
        throw new NotImplementedException();

    }

    public Pezzo[] listPezzoByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Pezzo[0];
    }

    public List queryPezzo(String condition, String orderBy) throws PersistentException {
        throw new NotImplementedException();
    }

    public List queryPezzo(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        throw new NotImplementedException();
    }

    public Iterator iteratePezzoByQuery(String condition, String orderBy) throws PersistentException {
        throw new NotImplementedException();
    }

    public Iterator iteratePezzoByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        throw new NotImplementedException();
    }

    public Pezzo[] listPezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        throw new NotImplementedException();
    }

    public Pezzo[] listPezzoByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        throw new NotImplementedException();
    }

    public List queryPezzo(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryPezzo(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iteratePezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iteratePezzoByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Pezzo loadPezzoByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Pezzo loadPezzoByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Pezzo loadPezzoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Pezzo loadPezzoByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Pezzo createPezzo() {
        return null;
    }

    public boolean save(Pezzo pezzo) throws PersistentException {
        return false;
    }

    public boolean delete(Pezzo pezzo) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Pezzo pezzo) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Pezzo pezzo, PersistentSession session) throws PersistentException {
        return false;
    }

    public boolean refresh(Pezzo pezzo) throws PersistentException {
        return false;
    }

    public boolean evict(Pezzo pezzo) throws PersistentException {
        return false;
    }

    public Pezzo loadPezzoByCriteria(PezzoCriteria pezzoCriteria) {
        return null;
    }

    public Pezzo[] listPezzoByCriteria(PezzoCriteria pezzoCriteria) {
        return new Pezzo[0];
    }
}
