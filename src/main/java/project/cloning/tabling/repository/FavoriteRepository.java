package project.cloning.tabling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cloning.tabling.domain.user.Favorite;

/**
 *  관심 가게 repository
 *
 */
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
