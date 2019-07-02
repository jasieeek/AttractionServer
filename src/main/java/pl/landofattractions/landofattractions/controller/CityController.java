package pl.landofattractions.landofattractions.controller;


import org.springframework.web.bind.annotation.*;
import pl.landofattractions.landofattractions.model.City;
import pl.landofattractions.landofattractions.repository.CityRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/cities")
    public List<City> getAttractions() {
        return (List<City>) cityRepository.findAll();
    }

    @PostMapping("/cities")
    void addCity(@RequestBody City city) {
        cityRepository.save(city);
    }

    @DeleteMapping("/cities/del/{id}")
    void delCity(@PathVariable long id) {
        cityRepository.deleteById(id);
    }
}
