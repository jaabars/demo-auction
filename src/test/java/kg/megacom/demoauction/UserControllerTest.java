package kg.megacom.demoauction;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.megacom.demoauction.controllers.UserController;
import kg.megacom.demoauction.model.dto.UserDto;
import kg.megacom.demoauction.services.UserService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    private UserDto userDto;
    private ObjectMapper objectMapper;
    @Before
    public void beforetest(){
        userDto =new UserDto();
        userDto.setName("Mirba");
        userDto.setPassword("1221");
        userDto.setLogin("Mirba@mao");
        Mockito.when(userService.saveUser(userDto)).thenReturn(userDto);
        userDto.setId(1l);
        objectMapper=new ObjectMapper();
    }
    @Test
    public void testUserController() throws Exception {
        mockMvc.perform(post("/user/save").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.id").value(userDto.getId()))
                .andExpect(jsonPath("$.name").value(userDto.getName()));
    }
}
