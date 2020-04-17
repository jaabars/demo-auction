package kg.megacom.demoauction;

import kg.megacom.demoauction.database.BidRepository;
import kg.megacom.demoauction.model.entity.Bid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest

public class BidRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private BidRepository bidRepository;
    @Test
    public void testSave(){
        Bid bid=new Bid();
            bid.setActive(true);
            bid.setAddDate(new Date());
            bid.setBidValue(20);

        System.out.println(bid.getAddDate());
        Bid found = testEntityManager.persist(bid);
        assertNotNull(found.getId());
        assertTrue(found.isActive());
    }
}
