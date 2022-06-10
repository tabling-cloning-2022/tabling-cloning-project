package project.cloning.tabling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cloning.tabling.domain.review.Review;

/**
 *  리뷰 repository
 *
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
