package project.cloning.tabling.domain.reservation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.cloning.tabling.domain.util.BaseTimeEntity;

/**
 *  원격 줄서기 예약 entity
 *
 */
@Getter
@NoArgsConstructor
@Entity
public class ReservationTableQueue extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_table_queue_id", nullable = false)
  private Long id;

  @Column(name = "ticket_number", nullable = false)
  private int ticketNumber;

  @Column(name = "status", nullable = false)
  private ReservationStatus status;

}