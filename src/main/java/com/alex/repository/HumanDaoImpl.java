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
        List list = entityManager
                .createQuery("select distinct h from Human h left join fetch h.phones p")
                .getResultList();
        entityManager.close();
        return list;
    }

    //    @Override
//    public Human findOne(Long id) {
//        EntityManager entityManager = getEntityManager();
//        Human human = (Human) entityManager
//                .createQuery("select h " +
//                        "from Human h " +
//                        "left join fetch h.phones p " +
//                        "where h.id =" + id
//                        + " group by h.id")
//                .getSingleResult();
//
//        entityManager.close();
//        return human;
//    }
    @Override
    public Human findOne(Long id) {
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Human> human = builder.createQuery(Human.class);
        Root<Human> root = human.from(Human.class);
        Join<Human, Phone> join = root.join("phones", JoinType.LEFT);
        human.where(builder.equal(root.get("id"), id));
        Human human1 = entityManager.createQuery(human).getSingleResult();
        return human1;
    }
}
