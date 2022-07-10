package com.alex.repository;

import com.alex.model.Human;
import com.alex.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class HumanDaoImpl extends AbstractHibernateDao<Human, Long> {
    @Autowired
//    @PersistenceContext
    private EntityManagerFactory managerFactory;

    public HumanDaoImpl(EntityManagerFactory managerFactory) {
        super(managerFactory, Human.class);
        this.managerFactory = managerFactory;
    }

    public EntityManager getEntityManager() {
        return managerFactory.createEntityManager();
    }

    @Override
    public List<Human> findAll() {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager
                    .createQuery("select distinct h from Human h join fetch h.phones", Human.class)
                    .getResultList();
        } finally {
            entityManager.close();
        }

//        EntityManager entityManager = getEntityManager();
//        List<Human> list = entityManager
//                .createQuery("select distinct h from Human h join fetch h.phones", Human.class)
//                .getResultList();
//        entityManager.close();
//        return list;
    }

    //        @Override
//    public Human findOne(Long id) {
//        EntityManager entityManager = getEntityManager();
//        try{
//            return entityManager
//                    .createQuery("select h from Human h join fetch h.phones where h.id =" + id, Human.class)
//                    .getSingleResult();
//        }finally {
//            entityManager.close();
//        }
//    }
    @Override
    public Human findOne(Long id) {
        EntityManager entityManager = getEntityManager();
        try {

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Human> human = builder.createQuery(Human.class);
            Root<Human> root = human.from(Human.class);
            root.fetch("phones");
            human.where(builder.equal(root.get("id"), id));
            Human human1 = entityManager.createQuery(human).getSingleResult();

            return human1;
        } finally {
            entityManager.close();
        }
    }
}
