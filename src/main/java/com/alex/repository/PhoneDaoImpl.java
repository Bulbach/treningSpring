package com.alex.repository;

import com.alex.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PhoneDaoImpl extends AbstractHibernateDao<Phone,Long>{
    @Autowired
    private EntityManager entityManager;

    public PhoneDaoImpl(EntityManager entityManager) {
        super(entityManager, Phone.class);
        this.entityManager = entityManager;
    }
}

