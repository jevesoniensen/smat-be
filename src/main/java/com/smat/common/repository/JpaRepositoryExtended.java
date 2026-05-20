package com.smat.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaRepositoryExtended<T, ID> extends JpaRepository<T, ID> {

    Updater<T> getUpdater();

    Class<T> getClazz();

    default ID parseId(String id) {
        return (ID) Integer.valueOf(id);
    }

    interface Updater<T> {
        T update(T body, T entity);
    }
}
