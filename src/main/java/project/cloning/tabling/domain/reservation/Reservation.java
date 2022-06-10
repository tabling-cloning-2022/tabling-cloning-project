package project.cloning.tabling.domain.reservation;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.cloning.tabling.domain.util.BaseTimeEntity;

/**
 *  store 예약 entity
 *
 */
@Getter
@NoArgsConstructor
@Entity
public class Reservation extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_id", nullable = false)
  private Long id;

  @Column(name = "datetime", nullable = false)
  private LocalDateTime datetime;

  @Column(name = "status", nullable = false)
  private ReservationStatus status;

  @Column(name = "description", nullable = false)
  private String description;

}
