package com.smat.app.acidentes.repository;

import com.smat.app.acidentes.model.Status;
import com.smat.common.repository.JpaRepositoryExtended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepositoryExtended<Status, Integer> {
    @Override
    default Updater<Status> getUpdater() {
        return null;
    }

    @Override
    default Class<Status> getClazz() {
        return Status.class;
    }
}
