package kg.megacom.demoauction;

import kg.megacom.demoauction.database.BidRepository;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.entity.Bid;
import kg.megacom.demoauction.services.BidService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidServiceTest {
    @Autowired
    private BidService bidService;
    @MockBean
    private BidRepository bidRepository;
    private BidDto bidDto;
    private Bid bid;
    @Before
    public void initData(){
        bidDto=new BidDto(){{
           setActive(true);
           setBidValue(200);
         //  setAddDate(new Date());
        }};
        bid= ClassMapper.INSTANCE.bidDtoToBid(bidDto);
        bid.setId(1l);
        Mockito.when(bidRepository.save(any())).thenReturn(bid);
    }
    @Test(expected = Exception.class)
    public  void bidSave(){
        bidDto=bidService.saveBid(bidDto);
        Assert.assertNotNull((bidDto.getId()));


    }
}
