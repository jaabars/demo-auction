package kg.megacom.demoauction.model.dto;


import lombok.Data;

import java.util.Date;

@Data
public class BidDto {
    private Long id;
    private Date addDate;
    private double bidValue;
    private boolean active;

    private LotDto lot;
    private CustomerDto customer;
}
