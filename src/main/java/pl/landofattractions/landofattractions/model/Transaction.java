package pl.landofattractions.landofattractions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String attractionName;
    private String price;
    private int numberOfPeople;
    private String finalPrice;


    public Transaction(String userName, String attractionName, String price, int numberOfPeople, String finalPrice) {
        this.userName = userName;
        this.attractionName = attractionName;
        this.price = price;
        this.numberOfPeople = numberOfPeople;
        this.finalPrice = finalPrice;
    }
}
