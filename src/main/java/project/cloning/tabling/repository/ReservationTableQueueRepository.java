package project.cloning.tabling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cloning.tabling.domain.reservation.ReservationTableQueue;

/**
 *  원격 줄서기 예약 repository
 *
 */
@Repository
public interface ReservationTableQueueRepository extends JpaRepository<ReservationTableQueue, Long> {

}
