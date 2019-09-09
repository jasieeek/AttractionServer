package pl.landofattractions.landofattractions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.landofattractions.landofattractions.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findById(long id);
    Place findByCity(String city);
}
