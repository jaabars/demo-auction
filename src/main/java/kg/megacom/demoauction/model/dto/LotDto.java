package kg.megacom.demoauction.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.demoauction.model.entity.Status;
import lombok.Data;

import java.util.Date;
@Data
public class LotDto {

    private Long id;

    private String name;

    private double minPrice;
    private double maxPrice;
    private double step;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date startDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date endDate;
    private StatusDto status;
}
