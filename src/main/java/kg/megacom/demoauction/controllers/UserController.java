package kg.megacom.demoauction.controllers;

import kg.megacom.demoauction.model.dto.UserDto;
import kg.megacom.demoauction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("save")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }
    @GetMapping("get")
    public List<UserDto> getUsers(){
        return userService.getUserList();
    }
}
