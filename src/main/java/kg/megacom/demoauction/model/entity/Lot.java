package kg.megacom.demoauction.model.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.nio.file.Files;
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
    private File file;

    private Date startDate;
    private Date endDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "status_id")
    private Status status;

}
