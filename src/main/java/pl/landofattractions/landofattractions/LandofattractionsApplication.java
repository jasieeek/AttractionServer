package pl.landofattractions.landofattractions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.landofattractions.landofattractions.model.Attraction;
import pl.landofattractions.landofattractions.model.Place;
import pl.landofattractions.landofattractions.model.Transaction;
import pl.landofattractions.landofattractions.model.User;
import pl.landofattractions.landofattractions.repository.AttractionRepository;
import pl.landofattractions.landofattractions.repository.PlaceRepository;
import pl.landofattractions.landofattractions.repository.TransactionRepository;
import pl.landofattractions.landofattractions.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class LandofattractionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandofattractionsApplication.class, args);
    }

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            // insert users
            User user1 = new User();
            user1.setName("Kamil");
            user1.setSurname("Jasiak");

            User user2 = new User();
            user2.setName("Agnieszka");
            user2.setSurname("Rogowska");

            User user3 = new User();
            user3.setName("Dawid");
            user3.setSurname("Kosmala");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        };
    }

    @Bean
    CommandLineRunner initPlaces(PlaceRepository placeRepository) {
        return args -> {
            //insert places
            Place place1 = new Place();
            place1.setCity("Ankara");
            place1.setCountry("Turkey");

            Place place2 = new Place();
            place2.setCity("Paris");
            place2.setCountry("France");

            Place place3 = new Place();
            place3.setCity("Spain");
            place3.setCountry("Madrid");

            placeRepository.save(place1);
            placeRepository.save(place2);
            placeRepository.save(place3);
        };
    }

    @Bean
    CommandLineRunner initAttractions(AttractionRepository attractionRepository, PlaceRepository placeRepository) {
        return args -> {
//          insert attraction
            Attraction a1 = new Attraction();
            a1.setName("Lot balonem");
            a1.setShortDescription("Zobacz cala turcje z lotu ptaka!");
            a1.setPrice(1000);
            a1.setPlace(placeRepository.findById(1));

            Attraction a2 = new Attraction();
            a2.setName("Zwiedzanie Wiezy Eiffel'a");
            a2.setShortDescription("Zobacz najbardziej popularna francuska budowle!");
            a2.setPrice(100);
            a2.setPlace(placeRepository.findById(2));

            attractionRepository.save(a1);
            attractionRepository.save(a2);
        };
    }

    @Bean
    CommandLineRunner initTransactions(TransactionRepository transactionRepository, UserRepository userRepository, AttractionRepository attractionRepository) {
        return args -> {
//          insert transaction
            Transaction t1 = new Transaction();
            t1.setNumberOfPeople(2);
            t1.setFinalPrice(2000);
            t1.setUser(userRepository.findById(1));
            List<Attraction> lista = new LinkedList<>(attractionRepository.findAll());
            t1.setAttractions(lista);

            transactionRepository.save(t1);
        };
    }
}
