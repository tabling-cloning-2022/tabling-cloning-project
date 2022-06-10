package project.cloning.tabling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cloning.tabling.domain.reservation.Reservation;

/**
 *  예약 repository
 *
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
