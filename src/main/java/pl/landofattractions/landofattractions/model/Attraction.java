package pl.landofattractions.landofattractions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attraction")
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAttraction")
    private long id;
    private String name;
    private String shortDescription;
    private int price;
    private double attractiveness;
    @OneToOne
    private Place place;

//    @ManyToOne
//    @JoinColumn(name = "idTransaction")
//    private Transaction transaction;
}
