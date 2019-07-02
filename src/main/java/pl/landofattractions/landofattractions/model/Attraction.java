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
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String city;
    private String shortDescription;
    private String price;

    public Attraction(String name, String city, String shortDescription, String price) {
        this.name = name;
        this.city = city;
        this.shortDescription = shortDescription;
        this.price = price;
    }
}
