package kg.megacom.demoauction.controllers;

import kg.megacom.demoauction.model.dto.StatusDto;
import kg.megacom.demoauction.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping("save")
    public StatusDto saveStatus(@RequestBody StatusDto statusDto){
        return statusService.saveStatus(statusDto);
    }
    @GetMapping("/get")
    public List<StatusDto> getStatus(){
        List<StatusDto> statusDtoList=new ArrayList<>();
        StatusDto statusDto=new StatusDto();
        statusDto.setId(1l);
        statusDto.setName("Активен");
        StatusDto statusDto1=new StatusDto();
        statusDto1.setId(2l);
        statusDto1.setName("Продан");
        StatusDto statusDto2=new StatusDto();
        statusDto2.setId(3l);
        statusDto2.setName("Закрыт");
        statusDtoList.add(statusDto);
        statusDtoList.add(statusDto1);
        statusDtoList.add(statusDto2);
        return statusDtoList;

        //return statusService.getStatusList();
    }
}
