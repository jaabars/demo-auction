package kg.megacom.demoauction.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;

import java.util.Date;
@Data
public class LotDto {

    private Long id;
@Column(unique = true)
    private String name;

    private double minPrice;
    private double maxPrice;
    private double step;

   // @JsonFormat(pattern = "dd.MM.yyyy")

    private Date startDate;

    //@JsonFormat(pattern = "dd.MM.yyyy")

    private Date endDate;

    private StatusDto status;
}
