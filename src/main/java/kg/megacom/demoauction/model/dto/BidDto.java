package kg.megacom.demoauction.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BidDto {
    private Long id;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date addDate;
    private double bidValue;
    private boolean active;

    private LotDto lot;
    private CustomerDto customer;
}
