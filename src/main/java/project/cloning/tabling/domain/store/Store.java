package project.cloning.tabling.domain.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.cloning.tabling.domain.reservation.ReservationStatus;
import project.cloning.tabling.domain.util.BaseTimeEntity;

/**
 * 가게 entity
 *
 */
@Getter
@NoArgsConstructor
@Entity
public class Store extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "store_id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "district", nullable = false)
  private District district;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "daily_code", nullable = false)
  private String dailyCode;

  @Column(name = "image", nullable = false)
  private String image;

  @Column(name = "reservation_table_queue_status", nullable = false)
  private ReservationStatus reservationTableQueueStatus;

  @Column(name = "reservation_status", nullable = false)
  private ReservationStatus reservationStatus;

  @Column(name = "food_type", nullable = false)
  private FoodType foodTyoe;

  @Column(name = "total_rating", nullable = false)
  private int totalRating;

  @Column(name = "total_comment", nullable = false)
  private int totalComment;

  @Column(name = "avg_wait_time", nullable = false)
  private int avgWaitTime;

  @Column(name = "description", nullable = false)
  private String description;

}
