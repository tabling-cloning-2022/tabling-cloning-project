package project.cloning.tabling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cloning.tabling.domain.user.MultipleOwnerStore;

/**
 *  주인 가게 권한 repository
 *
 */
@Repository
public interface MultipleOwnerStoreRepository extends JpaRepository<MultipleOwnerStore, Long> {

}
