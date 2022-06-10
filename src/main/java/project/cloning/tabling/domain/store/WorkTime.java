package project.cloning.tabling.domain.store;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.cloning.tabling.domain.util.BaseTimeEntity;

/**
 *  가게 운영 시간 entity
 *
 */
@Getter
@NoArgsConstructor
@Entity
public class WorkTime extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "work_time_id", nullable = false)
  private Long id;

  @Column(name = "day", nullable = false)
  private DAY day;

  @Column(name = "status", nullable = false)
  private StoreStatus status;

  @Column(name = "start_time", nullable = false)
  private Time startTime;

  @Column(name = "end_time", nullable = false)
  private Time endTime;

}

