package kg.megacom.demoauction.services;

import kg.megacom.demoauction.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    List<UserDto> getUserList();
}
