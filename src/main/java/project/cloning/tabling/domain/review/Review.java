package project.cloning.tabling.domain.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.cloning.tabling.domain.util.BaseTimeEntity;

/**
 *  댓글 entity
 *
 */
@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id", nullable = false)
  private Long id;

  @Column(name = "rating", nullable = false)
  private int rating;

  @Column(name = "comment", nullable = false)
  private String comment;

  @Column(name = "status", nullable = false)
  private ReviewStatus status;

}

