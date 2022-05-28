package com.alex.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T,PK extends Serializable> {

    T findOne(PK id);

    List<T> findAll();

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(PK entityId);

    void saveAll(List<T> saveCollection);
}
