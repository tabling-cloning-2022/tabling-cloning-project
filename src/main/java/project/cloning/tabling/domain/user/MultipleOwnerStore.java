package project.cloning.tabling.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.cloning.tabling.domain.util.BaseTimeEntity;

/**
 *  주인 가게 권한 entity
 */
@Getter
@NoArgsConstructor
@Entity
public class MultipleOwnerStore extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "multiple_owner_store_id", nullable = false)
  private Long id;

}
