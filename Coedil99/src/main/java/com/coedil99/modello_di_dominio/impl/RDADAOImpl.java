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
package com.coedil99.modello_di_dominio.impl;

import com.coedil99.modello_di_dominio.Coedil99PersistentManager;
import com.coedil99.modello_di_dominio.RDA;
import com.coedil99.modello_di_dominio.RDACriteria;
import com.coedil99.modello_di_dominio.RigaRDA;
import com.coedil99.modello_di_dominio.dao.RDADAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.List;



public class RDADAOImpl implements RDADAO {
    public RDA loadRDAByORMID(int ID) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return loadRDAByORMID(session, ID);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA getRDAByORMID(int ID) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return getRDAByORMID(session, ID);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA loadRDAByORMID(int ID, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return loadRDAByORMID(session, ID, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA getRDAByORMID(int ID, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return getRDAByORMID(session, ID, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA loadRDAByORMID(PersistentSession session, int ID) throws PersistentException {
        try {
            return (RDA) session.load(RDA.class, new Integer(ID));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA getRDAByORMID(PersistentSession session, int ID) throws PersistentException {
        try {
            return (RDA) session.get(RDA.class, new Integer(ID));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA loadRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        try {
            return (RDA) session.load(RDA.class, new Integer(ID), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA getRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        try {
            return (RDA) session.get(RDA.class, new Integer(ID), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public List queryRDA(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return queryRDA(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public List queryRDA(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return queryRDA(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA[] listRDAByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return listRDAByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA[] listRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return listRDAByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public List queryRDA(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From modello_di_RDA as RDA");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public List queryRDA(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From modello_di_RDA as RDA");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("RDA", lockMode);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA[] listRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        try {
            List list = queryRDA(session, condition, orderBy);
            return (RDA[]) list.toArray(new RDA[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA[] listRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            List list = queryRDA(session, condition, orderBy, lockMode);
            return (RDA[]) list.toArray(new RDA[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA loadRDAByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return loadRDAByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA loadRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return loadRDAByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA loadRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        RDA[] rDAs = listRDAByQuery(session, condition, orderBy);
        if (rDAs != null && rDAs.length > 0)
            return rDAs[0];
        else
            return null;
    }

    public RDA loadRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        RDA[] rDAs = listRDAByQuery(session, condition, orderBy, lockMode);
        if (rDAs != null && rDAs.length > 0)
            return rDAs[0];
        else
            return null;
    }

    public java.util.Iterator iterateRDAByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return iterateRDAByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public java.util.Iterator iterateRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return iterateRDAByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public java.util.Iterator iterateRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From modello_di_RDA as RDA");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public java.util.Iterator iterateRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From modello_di_RDA as RDA");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("RDA", lockMode);
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA createRDA() {
        return new RDA();
    }

    public boolean save(RDA rDA) throws PersistentException {
        try {
            Coedil99PersistentManager.instance().saveObject(rDA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean delete(RDA rDA) throws PersistentException {
        try {
            Coedil99PersistentManager.instance().deleteObject(rDA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean deleteAndDissociate(RDA rDA) throws PersistentException {
        try {
            if (rDA.getFornitore() != null) {
                rDA.getFornitore().rda.remove(rDA);
            }

            RigaRDA[] lRigheRDAs = rDA.righeRDA.toArray();
            for (int i = 0; i < lRigheRDAs.length; i++) {
                lRigheRDAs[i].setRda(null);
            }
            return delete(rDA);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean deleteAndDissociate(RDA rDA, PersistentSession session) throws PersistentException {
        try {
            if (rDA.getFornitore() != null) {
                rDA.getFornitore().rda.remove(rDA);
            }

            RigaRDA[] lRigheRDAs = rDA.righeRDA.toArray();
            for (int i = 0; i < lRigheRDAs.length; i++) {
                lRigheRDAs[i].setRda(null);
            }
            try {
                session.delete(rDA);
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean refresh(RDA rDA) throws PersistentException {
        try {
            Coedil99PersistentManager.instance().getSession().refresh(rDA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean evict(RDA rDA) throws PersistentException {
        try {
            Coedil99PersistentManager.instance().getSession().evict(rDA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RDA loadRDAByCriteria(RDACriteria rDACriteria) {
        RDA[] rDAs = listRDAByCriteria(rDACriteria);
        if (rDAs == null || rDAs.length == 0) {
            return null;
        }
        return rDAs[0];
    }

    public RDA[] listRDAByCriteria(RDACriteria rDACriteria) {
        return rDACriteria.listRDA();
    }
}
