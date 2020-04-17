package kg.megacom.demoauction;

import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.StatusDto;
import kg.megacom.demoauction.model.entity.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.ObjectInputFilter;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapperStatus {
    @Test(expected = Exception.class)
    public void testStatus() throws Exception {
        StatusDto statusDto= new StatusDto();
        statusDto.setId(1l);
        statusDto.setName("active");
        Status status = ClassMapper.INSTANCE.statusDtoToStatus(statusDto);
        StatusDto found = ClassMapper.INSTANCE.statusToStatusDto(status);

        assertEquals(found.getName(),statusDto.getName());
        if (found.getId()==null){
            throw new Exception();
        }
    }

}
