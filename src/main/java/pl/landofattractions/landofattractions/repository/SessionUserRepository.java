package pl.landofattractions.landofattractions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.landofattractions.landofattractions.model.SessionUser;

@Repository
public interface SessionUserRepository extends JpaRepository<SessionUser, Long> {
    SessionUser findFirstById(long id);
}
