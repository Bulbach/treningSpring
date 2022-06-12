package com.alex.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.util.List;

public class AbstractHibernateDao<T, PK extends Serializable> implements GenericDao<T, PK> {

    @Autowired
    private final EntityManagerFactory managerFactory;
    private final Class<T> clazz;

    public AbstractHibernateDao(EntityManagerFactory entityManager, Class<T> clazz) {
        this.managerFactory = entityManager;
        this.clazz = clazz;
    }

    public EntityManager getEntityManager() {
        return managerFactory.createEntityManager();
    }

    @Override
    public T findOne(PK id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        T entity = entityManager.find(clazz, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    public List<T> findAll() {
        EntityManager entityManager = getEntityManager();
        List<T> list = entityManager
                .createQuery(String.format("select t from %s t", clazz.getSimpleName()), clazz)
                .getResultList();
        entityManager.close();
        return list;
    }

    public T create(final T entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    public T update(final T entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    public void delete(final T entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteById(final PK entityId) {
        EntityManager entityManager = getEntityManager();
        T entity = entityManager.find(clazz, entityId);
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void saveAll(List<T> saveCollection) {
        for (T dto : saveCollection) {
            create(dto);
        }
    }
}