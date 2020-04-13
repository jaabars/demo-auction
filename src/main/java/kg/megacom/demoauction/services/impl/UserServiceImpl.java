package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.UserRepository;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.UserDto;
import kg.megacom.demoauction.model.entity.User;
import kg.megacom.demoauction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user= ClassMapper.INSTANCE.userDtoToUser(userDto);
        user=userRepository.save(user);
        userDto=ClassMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getUserList() {
         List<User> userList= userRepository.findAll();
         return ClassMapper.INSTANCE.userListToUserDtoList(userList);
    }
}
