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

        return statusService.getStatusList();

    }
   /* @GetMapping("/list")
    public List<StatusDto> getStatuses(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy){
        return statusService.getStatusList(pageNo,pageSize,sortBy);
    }*/
}
