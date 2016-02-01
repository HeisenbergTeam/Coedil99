package com.coedil99.modello_di_dominio.rest;

import com.coedil99.modello_di_dominio.DescrizionePezzo;
import com.coedil99.modello_di_dominio.DescrizionePezzoCriteria;
import com.coedil99.modello_di_dominio.Destinazione;
import com.coedil99.modello_di_dominio.DestinazioneCriteria;
import com.coedil99.modello_di_dominio.dao.DestinazioneDAO;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 31/01/2016.
 */
public class DestinazioneDAOImpl implements DestinazioneDAO {

    public Destinazione loadDestinazioneByORMID(int ID) throws PersistentException {
        return null;
    }

    public Destinazione getDestinazioneByORMID(int ID) throws PersistentException {
        return null;
    }

    public Destinazione loadDestinazioneByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Destinazione getDestinazioneByORMID(int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Destinazione loadDestinazioneByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Destinazione getDestinazioneByORMID(PersistentSession session, int ID) throws PersistentException {
        return null;
    }

    public Destinazione loadDestinazioneByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Destinazione getDestinazioneByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Destinazione[] listDestinazioneByQuery(String condition, String orderBy) throws PersistentException {
        return new Destinazione[0];
    }

    public Destinazione[] listDestinazioneByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Destinazione[0];
    }

    public List queryDestinazione(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryDestinazione(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateDestinazioneByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateDestinazioneByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Destinazione[] listDestinazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return new Destinazione[0];
    }

    public Destinazione[] listDestinazioneByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return new Destinazione[0];
    }

    public List queryDestinazione(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public List queryDestinazione(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Iterator iterateDestinazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Iterator iterateDestinazioneByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Destinazione loadDestinazioneByQuery(String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Destinazione loadDestinazioneByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Destinazione loadDestinazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        return null;
    }

    public Destinazione loadDestinazioneByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        return null;
    }

    public Destinazione createDestinazione() {
        return null;
    }

    public boolean save(Destinazione destinazione) throws PersistentException {
        return false;
    }

    public boolean delete(Destinazione destinazione) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Destinazione destinazione) throws PersistentException {
        return false;
    }

    public boolean deleteAndDissociate(Destinazione destinazione, PersistentSession session) throws PersistentException {
        return false;
    }

    public boolean refresh(Destinazione destinazione) throws PersistentException {
        return false;
    }

    public boolean evict(Destinazione destinazione) throws PersistentException {
        return false;
    }

    public Destinazione loadDestinazioneByCriteria(DestinazioneCriteria destinazioneCriteria) {
        return null;
    }

    public Destinazione[] listDestinazioneByCriteria(DestinazioneCriteria destinazioneCriteria) {
        return new Destinazione[0];
    }
}
