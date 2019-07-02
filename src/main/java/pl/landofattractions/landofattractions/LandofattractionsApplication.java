package pl.landofattractions.landofattractions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.landofattractions.landofattractions.model.Attraction;
import pl.landofattractions.landofattractions.model.City;
import pl.landofattractions.landofattractions.model.Transaction;
import pl.landofattractions.landofattractions.model.User;
import pl.landofattractions.landofattractions.repository.AttractionRepository;
import pl.landofattractions.landofattractions.repository.CityRepository;
import pl.landofattractions.landofattractions.repository.TransactionRepository;
import pl.landofattractions.landofattractions.repository.UserRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class LandofattractionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandofattractionsApplication.class, args);
    }

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
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
            userRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    CommandLineRunner initAttractions(AttractionRepository attractionRepository) {
        return args -> {
            Attraction atr1 = new Attraction();
            atr1.setName("Lot balonem");
            atr1.setCity("Ankara");
            atr1.setShortDescription("See almost a lot of turkey from the air passing by a lot of other travelers in balloons");
            atr1.setPrice("1000");

            Attraction atr2 = new Attraction();
            atr2.setName("Zwiedzanie wieży Eiffla");
            atr2.setCity("Paris");
            atr2.setShortDescription("See the most popular place in France, beautiful Eiffel Tower");
            atr2.setPrice("100");

            attractionRepository.save(atr1);
            attractionRepository.save(atr2);
            attractionRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    CommandLineRunner initCities(CityRepository cityRepository) {
        return args -> {
            City city1 = new City();
            city1.setName("Ankara");
            city1.setCountry("Turkey");

            City city2 = new City();
            city2.setName("Paris");
            city2.setCountry("France");

            City city3 = new City();
            city3.setName("London");
            city3.setCountry("England");
            cityRepository.save(city1);
            cityRepository.save(city2);
            cityRepository.save(city3);
            cityRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    CommandLineRunner initTransactions(TransactionRepository transactionRepository) {
        return args -> {
            Transaction t1 = new Transaction();
            t1.setUserName("Kamil Jasiak");
            t1.setAttractionName("Balloon flight");
            t1.setPrice("1000");
            t1.setNumberOfPeople(2);
            t1.setFinalPrice("2000");

            transactionRepository.save(t1);
            transactionRepository.findAll().forEach(System.out::println);
        };
    }
}
