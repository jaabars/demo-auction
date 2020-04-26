package kg.megacom.demoauction.database;

import kg.megacom.demoauction.model.entity.Lot;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LotRepository extends JpaRepository <Lot,Long> {
    int countByName(String name);
    int countByEndDateGreaterThanEqual(Date date);
    List<Lot> findAllByStatus_Name(@NonNull String status_name);


}
