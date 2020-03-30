package kg.megacom.demoauction.database;

import kg.megacom.demoauction.model.entity.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends JpaRepository <Lot,Long> {
}
