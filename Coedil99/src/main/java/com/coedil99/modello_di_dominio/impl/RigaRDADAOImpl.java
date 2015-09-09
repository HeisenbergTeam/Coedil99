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
import com.coedil99.modello_di_dominio.RigaRDA;
import com.coedil99.modello_di_dominio.RigaRDACriteria;
import com.coedil99.modello_di_dominio.dao.RigaRDADAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.List;


public class RigaRDADAOImpl implements RigaRDADAO {
    public RigaRDA loadRigaRDAByORMID(int ID) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return loadRigaRDAByORMID(session, ID);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA getRigaRDAByORMID(int ID) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return getRigaRDAByORMID(session, ID);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA loadRigaRDAByORMID(int ID, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return loadRigaRDAByORMID(session, ID, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA getRigaRDAByORMID(int ID, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return getRigaRDAByORMID(session, ID, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA loadRigaRDAByORMID(PersistentSession session, int ID) throws PersistentException {
        try {
            return (RigaRDA) session.load(RigaRDA.class, new Integer(ID));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA getRigaRDAByORMID(PersistentSession session, int ID) throws PersistentException {
        try {
            return (RigaRDA) session.get(RigaRDA.class, new Integer(ID));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA loadRigaRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        try {
            return (RigaRDA) session.load(RigaRDA.class, new Integer(ID), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA getRigaRDAByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
        try {
            return (RigaRDA) session.get(RigaRDA.class, new Integer(ID), lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public List queryRigaRDA(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return queryRigaRDA(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public List queryRigaRDA(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return queryRigaRDA(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA[] listRigaRDAByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return listRigaRDAByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA[] listRigaRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return listRigaRDAByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public List queryRigaRDA(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From modello_di_RigaRDA as RigaRDA");
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

    public List queryRigaRDA(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From modello_di_RigaRDA as RigaRDA");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("RigaRDA", lockMode);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA[] listRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        try {
            List list = queryRigaRDA(session, condition, orderBy);
            return (RigaRDA[]) list.toArray(new RigaRDA[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA[] listRigaRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            List list = queryRigaRDA(session, condition, orderBy, lockMode);
            return (RigaRDA[]) list.toArray(new RigaRDA[list.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA loadRigaRDAByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return loadRigaRDAByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA loadRigaRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return loadRigaRDAByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA loadRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        RigaRDA[] rigaRDAs = listRigaRDAByQuery(session, condition, orderBy);
        if (rigaRDAs != null && rigaRDAs.length > 0)
            return rigaRDAs[0];
        else
            return null;
    }

    public RigaRDA loadRigaRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        RigaRDA[] rigaRDAs = listRigaRDAByQuery(session, condition, orderBy, lockMode);
        if (rigaRDAs != null && rigaRDAs.length > 0)
            return rigaRDAs[0];
        else
            return null;
    }

    public java.util.Iterator iterateRigaRDAByQuery(String condition, String orderBy) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return iterateRigaRDAByQuery(session, condition, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public java.util.Iterator iterateRigaRDAByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
        try {
            PersistentSession session = Coedil99PersistentManager.instance().getSession();
            return iterateRigaRDAByQuery(session, condition, orderBy, lockMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public java.util.Iterator iterateRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
        StringBuffer sb = new StringBuffer("From modello_di_RigaRDA as RigaRDA");
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

    public java.util.Iterator iterateRigaRDAByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
        StringBuffer sb = new StringBuffer("From modello_di_RigaRDA as RigaRDA");
        if (condition != null)
            sb.append(" Where ").append(condition);
        if (orderBy != null)
            sb.append(" Order By ").append(orderBy);
        try {
            Query query = session.createQuery(sb.toString());
            query.setLockMode("RigaRDA", lockMode);
            return query.iterate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA createRigaRDA() {
        return new RigaRDA();
    }

    public boolean save(RigaRDA rigaRDA) throws PersistentException {
        try {
            Coedil99PersistentManager.instance().saveObject(rigaRDA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean delete(RigaRDA rigaRDA) throws PersistentException {
        try {
            Coedil99PersistentManager.instance().deleteObject(rigaRDA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean deleteAndDissociate(RigaRDA rigaRDA) throws PersistentException {
        try {
            if (rigaRDA.getPezzo() != null) {
                rigaRDA.getPezzo().rigaRDA.remove(rigaRDA);
            }

            if (rigaRDA.getRda() != null) {
                rigaRDA.getRda().righeRDA.remove(rigaRDA);
            }

            return delete(rigaRDA);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean deleteAndDissociate(RigaRDA rigaRDA, PersistentSession session) throws PersistentException {
        try {
            if (rigaRDA.getPezzo() != null) {
                rigaRDA.getPezzo().rigaRDA.remove(rigaRDA);
            }

            if (rigaRDA.getRda() != null) {
                rigaRDA.getRda().righeRDA.remove(rigaRDA);
            }

            try {
                session.delete(rigaRDA);
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean refresh(RigaRDA rigaRDA) throws PersistentException {
        try {
            Coedil99PersistentManager.instance().getSession().refresh(rigaRDA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public boolean evict(RigaRDA rigaRDA) throws PersistentException {
        try {
            Coedil99PersistentManager.instance().getSession().evict(rigaRDA);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistentException(e);
        }
    }

    public RigaRDA loadRigaRDAByCriteria(RigaRDACriteria rigaRDACriteria) {
        RigaRDA[] rigaRDAs = listRigaRDAByCriteria(rigaRDACriteria);
        if (rigaRDAs == null || rigaRDAs.length == 0) {
            return null;
        }
        return rigaRDAs[0];
    }

    public RigaRDA[] listRigaRDAByCriteria(RigaRDACriteria rigaRDACriteria) {
        return rigaRDACriteria.listRigaRDA();
    }
}
