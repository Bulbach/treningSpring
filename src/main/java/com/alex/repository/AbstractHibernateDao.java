package com.alex.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDao<T, PK extends Serializable> implements GenericDao<T, PK> {

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
        try {

            entityManager.getTransaction().begin();
            T entity = entityManager.find(clazz, id);
            entityManager.getTransaction().commit();
            return entity;

        } catch (Exception e) {
            throw new RuntimeException("Failed question findOne", e);
        } finally {
            entityManager.close();
        }
    }

    public List<T> findAll() {
        EntityManager entityManager = getEntityManager();
        try {

            List<T> list = entityManager
                    .createQuery(String.format("select t from %s t", clazz.getSimpleName()), clazz)
                    .getResultList();
            return list;

        } catch (Exception e) {
            throw new RuntimeException("Failed question findAll", e);
        } finally {
            entityManager.close();
        }
    }

    public T create(final T entity) {
        EntityManager entityManager = getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return entity;

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Create failed", e);
        } finally {
            entityManager.close();
        }
    }

    public T update(final T entity) {
        EntityManager entityManager = getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return entity;

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed update method", e);
        } finally {
            entityManager.close();
        }
    }

    public void delete(final T entity) {
        EntityManager entityManager = getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed method delete", e);
        } finally {
            entityManager.close();
        }
    }

    public void deleteById(final PK entityId) {
        EntityManager entityManager = getEntityManager();
        try {

            T entity = entityManager.find(clazz, entityId);
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Filed method deleteById", e);
        } finally {
            entityManager.close();
        }
    }

    public void saveAll(List<T> saveCollection) {
        if (saveCollection != null) {
            for (T dto : saveCollection) {
                create(dto);
            }
        }else {
            throw new RuntimeException("Filed method saveAll, collection is null");
        }
    }
}