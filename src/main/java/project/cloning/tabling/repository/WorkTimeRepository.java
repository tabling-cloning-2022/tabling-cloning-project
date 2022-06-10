package project.cloning.tabling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cloning.tabling.domain.store.WorkTime;

/**
 *  가게 운영 시간 repository
 *
 */
@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {

}
