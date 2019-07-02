package pl.landofattractions.landofattractions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.landofattractions.landofattractions.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
