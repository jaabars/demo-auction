package kg.megacom.demoauction.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "bids")
public class Bid {
    @Id
    @GeneratedValue
    @Column(name = "bid_id")
    private Long id;
    private Date addDate;
    private double bidValue;
    private boolean active;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lot_id")
    private Lot lot;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
