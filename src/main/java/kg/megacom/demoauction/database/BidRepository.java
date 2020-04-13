package kg.megacom.demoauction.database;

import kg.megacom.demoauction.model.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid,Long> {
List<Bid> getByLot_Id(Long id);



}
