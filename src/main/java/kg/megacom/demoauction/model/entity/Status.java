package kg.megacom.demoauction.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue
    @Column(name = "status_id")
    private Long id;
    private String name;
}
