package kg.megacom.demoauction;

import kg.megacom.demoauction.database.BidRepository;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.dto.CustomerDto;
import kg.megacom.demoauction.model.dto.LotDto;
import kg.megacom.demoauction.model.dto.StatusDto;
import kg.megacom.demoauction.model.entity.Bid;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapperBid   {

   @Test
   @Ignore
    public void testBidMapper() throws ParseException {
//        BidDto bidDto=new BidDto(){
//            {
//                setId(1l);
//
//        setActive(true);
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd.MM.yyyy");
//        Date date=simpleDateFormat.parse("05.12.2020");
//
//        setAddDate(date);
//        CustomerDto customer= new CustomerDto();
//        customer.setId(2l);
//        customer.setPhone("+996556556");
//        setCustomer(customer);
//        setBidValue(250);
//        LotDto lot=new LotDto();
//        lot.setId(3l);
//        lot.setMinPrice(220);
//        lot.setMaxPrice(440);
//        lot.setName("BMW");
//        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd.MM.yyyy");
//        Date date1=simpleDateFormat1.parse("04.12.2020");
//        lot.setStartDate(date1);
//        Date date2=simpleDateFormat1.parse("06.12.2020");
//        lot.setEndDate(date2);
//        lot.setStep(50);
//        StatusDto status=new StatusDto();
//        status.setId(4l);
//        status.setName("active");
//        lot.setStatus(status);
//        setLot(lot);}};
//        Bid bid=new Bid();
//        bid=ClassMapper.INSTANCE.bidDtoToBid(bidDto);
//        BidDto found=ClassMapper.INSTANCE.bidToBidDto(bid);
//        assertEquals(bidDto.getId(),found.getId());
//        assertEquals(bidDto.getLot().getId(),found.getLot().getId());

    }
}
