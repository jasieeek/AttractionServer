package pl.landofattractions.landofattractions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.landofattractions.landofattractions.knapsack.MainKnapsack;
import pl.landofattractions.landofattractions.model.*;
import pl.landofattractions.landofattractions.repository.*;

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
            user1.setUserName("jasiek");
            user1.setPassword("12345");
            user1.setPasswordConfirm("12345");

            User user2 = new User();
            user2.setName("Agnieszka");
            user2.setSurname("Rogowska");
            user2.setUserName("rogii");
            user2.setPassword("54321");
            user2.setPasswordConfirm("54321");

            User user3 = new User();
            user3.setName("Dawid");
            user3.setSurname("Kosmala");
            user3.setUserName("kosi");
            user3.setPassword("99999");
            user3.setPasswordConfirm("99999");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        };
    }

    @Bean
    CommandLineRunner initSessionUser(UserRepository userRepository, SessionUserRepository sessionUserRepository) {
        return args -> {
            SessionUser sessionUser = new SessionUser();
            sessionUser.setStatus(false);
            User user = userRepository.findById(1);
            sessionUser.setUser(user);
            sessionUserRepository.save(sessionUser);
        };
    }

    @Bean
    CommandLineRunner initTransactions(TransactionRepository transactionRepository, UserRepository userRepository, AttractionRepository attractionRepository) {
        return args -> {
//          insert transaction
            Transaction t1 = new Transaction();
            t1.setNumberOfPeople(5);

            List<Attraction> attractionList = new LinkedList<>(attractionRepository.findAllByPlaceId(1));

            t1.setFinalPrice((attractionList.stream().mapToInt(i -> i.getPrice()).sum())*t1.getNumberOfPeople());
            t1.setUser(userRepository.findById(1));
            t1.setAttractions(attractionList);

            transactionRepository.save(t1);
        };
    }
}
