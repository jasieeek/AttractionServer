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
//@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaction")
    private long id;
    private int numberOfPeople;
    private int finalPrice;
    @OneToOne
    private User user;
//    1
    @OneToMany
    private List<Attraction> attractions;
}
