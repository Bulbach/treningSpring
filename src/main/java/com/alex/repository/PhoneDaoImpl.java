package com.alex.repository;

import com.alex.model.Human;
import com.alex.model.Phone;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;

@Repository
public class PhoneDaoImpl extends AbstractHibernateDao<Phone, Long> {
    @Autowired
    private EntityManagerFactory managerFactory;

    public PhoneDaoImpl(EntityManagerFactory managerFactory) {
        super(managerFactory, Phone.class);
        this.managerFactory = managerFactory;
    }

    public EntityManager getEntityManager() {
        return managerFactory.createEntityManager();
    }


    @Override
    public Phone findOne(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager
                    .createQuery("select p from Phone p join fetch p.human where p.id =" + id, Phone.class)
                    .getSingleResult();
        } finally {
            entityManager.close();
        }
    }
        /*
        // Method with CriteriaBuilder is working
    @Override
    public Phone findOne(Long id) {
        EntityManager entityManager = getEntityManager();
        try {

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Phone> phone = builder.createQuery(Phone.class);
            Root<Phone> root = phone.from(Phone.class);
            root.fetch("human");
            phone.where(builder.equal(root.get("id"), id));
            Phone phone1 = entityManager.createQuery(phone).getSingleResult();
            return phone1;

        } finally {
            entityManager.close();
        }
    }
     */

}

