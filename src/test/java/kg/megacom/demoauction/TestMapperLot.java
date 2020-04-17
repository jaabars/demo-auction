package kg.megacom.demoauction;

import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.LotDto;
import kg.megacom.demoauction.model.entity.Lot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapperLot {
    @Test
    public void testLot(){
        LotDto lotDto =new LotDto();
        lotDto.setId(1l);
        lotDto.setStep(20.03);
        Lot lot=new Lot();
        lot= ClassMapper.INSTANCE.lotDtoTLot(lotDto);
        LotDto found=ClassMapper.INSTANCE.lotToLotDto(lot);

        assertEquals(found.getId(),lotDto.getId());
        assertEquals(found.getStep(),lotDto.getStep(),0.01);
    }
}
