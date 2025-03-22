package com.Spring2.Factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Entity_SessionFactory {
    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();    
        }
        catch (Throwable e)
        {
            System.out.println(e.toString());
            throw new ExceptionInInitializerError(e);
        }
        
    }

    public static void close()
    {
        // Close all cached and active connection pools
        getSessionFactory().close();
    }
}
