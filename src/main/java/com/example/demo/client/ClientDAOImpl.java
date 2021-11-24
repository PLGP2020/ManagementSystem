package com.example.demo.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
import java.util.List;


public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;



    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public  void insertClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
       // Query query = (Query) session.createQuery("INSERT INTO client VALUES()");

    }

    @Override
    public List<Client> getAll() {

        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from client").list();
    }

    @Override
    public void saveClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.save(client);
    }

    @Override
    public void updateClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.createQuery("UPDATE client SET ");
        query.executeUpdate();
    }

    @Override
    public void deleteClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(client);
    }

    @Override
    public Client selectClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class,id);
        return client;
    }
}
