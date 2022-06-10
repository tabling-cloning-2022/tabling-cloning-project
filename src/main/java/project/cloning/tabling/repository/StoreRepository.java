package project.cloning.tabling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cloning.tabling.domain.store.Store;

/**
 *  가게 repository
 *
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
