package pl.landofattractions.landofattractions.controller;


import org.springframework.web.bind.annotation.*;
import pl.landofattractions.landofattractions.model.Place;
import pl.landofattractions.landofattractions.repository.PlaceRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlaceController {
    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/places")
    public List<Place> getPlaces() {
        return (List<Place>) placeRepository.findAll();
    }

    @PostMapping("/places")
    void addPlace(@RequestBody Place place) {
        placeRepository.save(place);
    }

    @DeleteMapping("/places/del/{id}")
    void delPlace(@PathVariable long id) {
        placeRepository.deleteById(id);
    }

    @GetMapping("/places/{id}")
    public Place getPlace(@PathVariable long id) {
        return placeRepository.findById(id);
    }

}
