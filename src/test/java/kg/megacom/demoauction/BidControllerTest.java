package kg.megacom.demoauction;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.megacom.demoauction.controllers.BidController;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.services.BidService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Date;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@WebMvcTest(BidController.class)
public class BidControllerTest {

    @MockBean
    private BidService bidService;
    @Autowired
    private MockMvc mockMvc;
    private  BidDto bidDto;
    private   ObjectMapper objectMapper;
    @Before
    public void beforeAll(){
        bidDto=new BidDto();
        bidDto.setAddDate(new Date());
        bidDto.setActive(true);
        bidDto.setBidValue(20);

        Mockito.when(bidService.saveBid(bidDto)).thenReturn(bidDto);
        objectMapper=new ObjectMapper();
    }
    @Test
    public  void testReturn200() throws Exception {
        mockMvc.perform(post("/bid/save").accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(bidDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //assertEquals(20.0,bidDto.getBidValue(),0.1);
        System.out.println(bidDto.getAddDate());
        System.out.println(bidDto.getBidValue());
    }
}
