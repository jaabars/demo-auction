package kg.megacom.demoauction;

import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.UserDto;
import kg.megacom.demoauction.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapperUser {
    @Test
    public void testUserMapper(){
        UserDto userDto=new UserDto();
        userDto.setId(1l);
        userDto.setName("Aibek");
        userDto.setLogin("aibek121@gmail.com");
        userDto.setPassword("12345");
        User user= ClassMapper.INSTANCE.userDtoToUser(userDto);
        UserDto found=ClassMapper.INSTANCE.userToUserDto(user);
        assertEquals(userDto.getId(),found.getId());
        assertEquals(userDto.getName(),found.getName());
    }
}
