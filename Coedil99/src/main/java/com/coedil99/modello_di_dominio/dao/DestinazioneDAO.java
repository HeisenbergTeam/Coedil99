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

import com.coedil99.modello_di_dominio.Destinazione;
import com.coedil99.modello_di_dominio.DestinazioneCriteria;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public interface DestinazioneDAO {
    public Destinazione loadDestinazioneByORMID(int ID) throws PersistentException;

    public Destinazione getDestinazioneByORMID(int ID) throws PersistentException;

    public Destinazione loadDestinazioneByORMID(int ID, LockMode lockMode) throws PersistentException;

    public Destinazione getDestinazioneByORMID(int ID, LockMode lockMode) throws PersistentException;

    public Destinazione loadDestinazioneByORMID(PersistentSession session, int ID) throws PersistentException;

    public Destinazione getDestinazioneByORMID(PersistentSession session, int ID) throws PersistentException;

    public Destinazione loadDestinazioneByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public Destinazione getDestinazioneByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException;

    public Destinazione[] listDestinazioneByQuery(String condition, String orderBy) throws PersistentException;

    public Destinazione[] listDestinazioneByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryDestinazione(String condition, String orderBy) throws PersistentException;

    public java.util.List queryDestinazione(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateDestinazioneByQuery(String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateDestinazioneByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public Destinazione[] listDestinazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public Destinazione[] listDestinazioneByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.List queryDestinazione(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.List queryDestinazione(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public java.util.Iterator iterateDestinazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public java.util.Iterator iterateDestinazioneByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public Destinazione loadDestinazioneByQuery(String condition, String orderBy) throws PersistentException;

    public Destinazione loadDestinazioneByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public Destinazione loadDestinazioneByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;

    public Destinazione loadDestinazioneByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException;

    public Destinazione createDestinazione();

    public boolean save(Destinazione destinazione) throws PersistentException;

    public boolean delete(Destinazione destinazione) throws PersistentException;

    public boolean deleteAndDissociate(Destinazione destinazione) throws PersistentException;

    public boolean deleteAndDissociate(Destinazione destinazione, PersistentSession session) throws PersistentException;

    public boolean refresh(Destinazione destinazione) throws PersistentException;

    public boolean evict(Destinazione destinazione) throws PersistentException;

    public Destinazione loadDestinazioneByCriteria(DestinazioneCriteria destinazioneCriteria);

    public Destinazione[] listDestinazioneByCriteria(DestinazioneCriteria destinazioneCriteria);
}
