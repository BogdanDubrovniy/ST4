package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.User;
import com.dubrovnyi.company.services.session.factory.SessionFactoryService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static com.dubrovnyi.company.constants.ConstantClass.FIRST_ELEMENT_LIST_INDEX;
import static com.dubrovnyi.company.constants.ConstantClass.USER_LOGIN_VALUE;
import static com.dubrovnyi.company.constants.ConstantClass.USER_PASSWORD_VALUE;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class UserDAO {

    private DAOHandler handler;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public UserDAO() {
        handler = DAOHandler.getInstanceHandler();
        sessionFactory = SessionFactoryService.getSessionFactoryInstance();
    }

    public void updateUser(User userToUpdate) {
        handler.updateObject(userToUpdate);
    }

    public User getUserByUserLogin(String userLogin) {
        User user = null;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Query query = session
                .createQuery("from User user where user.userLogin = :userLogin");
        query.setParameter(USER_LOGIN_VALUE, userLogin);

        if (query.list() != null) {
            user = (User) query.list().get(FIRST_ELEMENT_LIST_INDEX);
        }

        session.close();
        return user;
    }

    public User getUserByUserLoginAndPassword(String userLogin, String userPassword) {
        User user = null;
        session = sessionFactory.openSession();

        Query query = session
                .createQuery("from User user where user.userLogin = :userLogin "
                        + "and user.userPassword = :userPassword");
        query.setParameter(USER_LOGIN_VALUE, userLogin);
        query.setParameter(USER_PASSWORD_VALUE, userPassword);

        if (query.list() != null) {
            user = (User) query.list().get(FIRST_ELEMENT_LIST_INDEX);
        }

        session.close();
        return user;
    }
}
