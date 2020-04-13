package kg.megacom.demoauction.database;

import kg.megacom.demoauction.model.entity.Lot;
import kg.megacom.demoauction.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface LotRepository extends JpaRepository <Lot,Long> {
    int countByName(String name);
    int countByEndDateGreaterThanEqual(Date date);


}
