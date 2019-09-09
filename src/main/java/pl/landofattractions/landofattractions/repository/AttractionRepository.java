package pl.landofattractions.landofattractions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.landofattractions.landofattractions.model.Attraction;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
//    List<Attraction> findAllByCity(String city);
    Attraction findById(long id);
    List<Attraction> findAllByPlaceId(long id);


}
