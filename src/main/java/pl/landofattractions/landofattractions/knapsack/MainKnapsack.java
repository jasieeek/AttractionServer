package pl.landofattractions.landofattractions.knapsack;

import pl.landofattractions.landofattractions.model.Attraction;
import pl.landofattractions.landofattractions.repository.AttractionRepository;
import pl.landofattractions.landofattractions.repository.PlaceRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainKnapsack {

   private final AttractionRepository attractionRepository;
   private final PlaceRepository placeRepository;

   public MainKnapsack(AttractionRepository attractionRepository, PlaceRepository placeRepository) {
      this.attractionRepository = attractionRepository;
      this.placeRepository = placeRepository;
   }

   public List<Attraction> returnListAttractions(String city, int capacity) {

      List<Attraction> attractionList = attractionRepository.findAllByPlaceId(placeRepository.findByCity(city).getId());

      if (attractionList.isEmpty()) return null;
      
      List<Item> items = new LinkedList<>();
      for (Attraction attraction : attractionList) {
         Item item = new Item();
         item.label = (int) attraction.getId();
         item.value = attraction.getAttractiveness();
         item.weight = attraction.getPrice();
         items.add(item);
      }
      
//      List<KnapsackSolver> solvers = new ArrayList<>();
//
//      solvers.add(new KnapsackSolver(items, capacity));

      KnapsackSolver knapsackSolver = new KnapsackSolver(items, capacity);
//      System.out.println(solvers.get(0).solve());


      return getAttractions(knapsackSolver.solve().items);
   }

   private List<Attraction> getAttractions(List<Item> items) {
      List<Attraction> attractionList = new LinkedList<>();

      for (Item item: items) {
         attractionList.add(this.attractionRepository.findById(item.label));
      }

      return attractionList;
   }
}
