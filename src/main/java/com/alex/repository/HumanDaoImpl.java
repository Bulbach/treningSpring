package com.alex.repository;

import com.alex.model.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HumanDaoImpl extends AbstractHibernateDao<Human, Long> {
    @Autowired
    private EntityManager entityManager;

    public HumanDaoImpl(EntityManager entityManager) {
        super(entityManager, Human.class);
        this.entityManager = entityManager;
    }

//    @Override
//    public List<Human> findAll() {
//
//        return entityManager
//                .createQuery("select t from Human t", Human.class)
//                .getResultList();
//    }
}
