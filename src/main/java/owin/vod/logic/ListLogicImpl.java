package owin.vod.logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import owin.vod.model.Account;
import owin.vod.model.User;

import java.util.List;

public class ListLogicImpl implements ListLogic {

    private static SessionFactory sessionFactory;

    public List listUsers() {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();

        transaction.commit();
        session.close();
        return users;
    }

    public List listAccounts() {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Account> accounts = session.createQuery("FROM Account").list();

        transaction.commit();
        session.close();
        return accounts;
    }


    public int getSum(){

        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List account = session.createQuery("select sum(account) from Account").list();

        transaction.commit();
        session.close();

        return Integer.parseInt(account.get(0).toString());
    }

    public String getRichestUser(){

        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List user = session.createQuery("select name from User where userId in (select userId FROM Account group by userId having sum(account) >= all (select sum(account) from Account group by userId))").list();

        transaction.commit();
        session.close();

        return user.get(0).toString();
    }

}
