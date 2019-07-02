package pl.landofattractions.landofattractions.controller;

import org.springframework.web.bind.annotation.*;
import pl.landofattractions.landofattractions.model.Attraction;
import pl.landofattractions.landofattractions.repository.AttractionRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AttractionController {
    private final AttractionRepository attractionRepository;

    public AttractionController(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @GetMapping("/attractions")
    public List<Attraction> getAttractions() {
        return (List<Attraction>) attractionRepository.findAll();
    }

    @GetMapping("/attractions/city/{name}")
    public List<Attraction> getAttractionsByCity(@PathVariable("name") String name) {
        return (List<Attraction>) attractionRepository.findAllByCity(name);
    }

    @PostMapping("/attractions")
    void addAttraction(@RequestBody Attraction attraction) {
        attractionRepository.save(attraction);
    }

    @DeleteMapping("/attractions/del/{id}")
    void delAttraction(@PathVariable long id) {
        attractionRepository.deleteById(id);
    }
}
