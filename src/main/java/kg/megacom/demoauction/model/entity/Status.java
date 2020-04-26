package kg.megacom.demoauction.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Status {
    @Id
    @GeneratedValue
    @Column(name = "status_id")
    private Long id;
    @NonNull
    private String name;
}
