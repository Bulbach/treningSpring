package com.alex.repository;

import com.alex.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class PhoneDaoImpl extends AbstractHibernateDao<Phone, Long> {
        @Autowired
//    @PersistenceContext
    private EntityManagerFactory managerFactory;

    public PhoneDaoImpl(EntityManagerFactory managerFactory) {
        super(managerFactory, Phone.class);
        this.managerFactory = managerFactory;
    }

    public EntityManager getEntityManager() {
        return managerFactory.createEntityManager();
    }
}

