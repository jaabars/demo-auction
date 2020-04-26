package kg.megacom.demoauction.model.dto;


import lombok.Data;

import javax.persistence.Column;


import java.io.File;
import java.util.Date;
@Data
public class LotDto {

    private Long id;
    @Column(unique = true)
    private String name;

    private double minPrice;
    private double maxPrice;
    private double step;
    private File file;

   // @JsonFormat(pattern = "dd.MM.yyyy")

    private Date startDate;

    //@JsonFormat(pattern = "dd.MM.yyyy")

    private Date endDate;

    private StatusDto status;
}
