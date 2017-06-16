package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.beans.CreditCard;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by Bohdan on 16.06.2017.
 */
class DAOHandler {
    private static final Logger LOG = Logger.getLogger(DAOHandler.class);

    private static DAOHandler handler;

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    private DAOHandler() {
        Configuration configuration = new AnnotationConfiguration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    static DAOHandler getInstanceHandler() {
        if (handler == null) {
            handler = new DAOHandler();

            LOG.debug("Was created new DAO Handler");
        }
        return handler;
    }

    void createObject(Object objectForCreate) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.flush();
        session.save(objectForCreate);
        transaction.commit();
        session.close();
    }

    Object getObjectById(Class clazz, int objectId) {
        Object objectFromDB;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        objectFromDB = session.get(clazz, objectId);
        transaction.commit();
        session.close();
        LOG.info("getObjectById() is successful");
        return objectFromDB;
    }

    boolean createAccountWithCard(Account accountForCreate, CreditCard creaditCardForCreate) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.save(accountForCreate);
        int createdAccountId = accountForCreate.getId();

        if (createdAccountId == 0) {
            rollbackTransaction();
            return false;
        }

        creaditCardForCreate.setId(createdAccountId);
        session.save(creaditCardForCreate);

        if (createdAccountId != creaditCardForCreate.getId()) {
            rollbackTransaction();
            return false;
        }

        transaction.commit();
        session.close();
        return true;
    }

    /**
     * If any troubles in transaction - do rollback and close current session
     */
    private void rollbackTransaction() {
        LOG.info("Was called rollback transaction");
        transaction.rollback();
        session.close();
    }
}
