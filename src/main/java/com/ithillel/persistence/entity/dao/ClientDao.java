package com.ithillel.persistence.entity.dao;

import com.ithillel.persistence.entity.ClientEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class ClientDao {

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;


    @Transactional
    public Integer createClient(final ClientEntity client) {
        entityManager.persist(client);
        return client.getId();
    }
}
