package com.dubrovnyi.company.services.session.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class SessionFactoryService {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactoryInstance() {
        if (sessionFactory == null) {
            Configuration configuration = new AnnotationConfiguration().configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
