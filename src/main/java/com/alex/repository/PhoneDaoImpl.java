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
//    @PersistenceContext
    private EntityManagerFactory managerFactory;

    public PhoneDaoImpl(EntityManagerFactory managerFactory) {
        super(managerFactory, Phone.class);
        this.managerFactory = managerFactory;
    }

    public EntityManager getEntityManager() {
        return managerFactory.createEntityManager();
    }
    @Override
    public Phone findOne(Long id){
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> phone = builder.createQuery(Phone.class);
        Root<Phone> root = phone.from(Phone.class);
        root.join("human", JoinType.LEFT);
        phone.where(builder.equal(root.get("id"),id));
        return entityManager.createQuery(phone).getSingleResult();

    }

}

