package kg.megacom.demoauction.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Lot {
    @Id
    @GeneratedValue
    @Column(name = "lot_id")
    private Long id;

    private String name;

    private double minPrice;
    private double maxPrice;
    private double step;

    private Date startDate;
    private Date endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

}
