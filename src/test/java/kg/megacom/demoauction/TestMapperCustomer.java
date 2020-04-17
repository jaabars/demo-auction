package kg.megacom.demoauction;


import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.CustomerDto;
import kg.megacom.demoauction.model.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapperCustomer {


    @Test
    public void customerTest(){
        CustomerDto customerDto=new CustomerDto();
        customerDto.setId(1l);
        customerDto.setPhone("+996556556");
        Customer customer = ClassMapper.INSTANCE.customerDtoToCustomerDto(customerDto);
        CustomerDto found=ClassMapper.INSTANCE.customerToCustomerDto(customer);

        assertEquals(found.getId(),customerDto.getId());
        assertEquals(found.getPhone(),customer.getPhone());
    }
}
