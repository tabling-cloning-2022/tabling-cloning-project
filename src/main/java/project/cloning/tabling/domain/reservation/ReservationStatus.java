package project.cloning.tabling.domain.reservation;

import lombok.Getter;

/**
 *  예약 상태 enum
 *
 */
@Getter
public enum ReservationStatus {

  // 사용 여부
  AUTO,
  MANUAL,

  // 예약 상태
  REQUESTED,
  WAITING,
  COMPLETE,
  CANCELED,
  NO_SHOW

}
