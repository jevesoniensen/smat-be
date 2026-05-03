package com.smat.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaRepositoryExtended<T, ID> extends JpaRepository<T, ID> {

    Updater<T> getUpdater();

    Class<T> getClazz();

    interface Updater<T> {
        T update(T body, T entity);
    }
}
