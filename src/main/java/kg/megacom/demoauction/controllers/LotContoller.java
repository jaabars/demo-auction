package kg.megacom.demoauction.controllers;

import io.swagger.annotations.ApiParam;
import kg.megacom.demoauction.model.dto.LotDto;
import kg.megacom.demoauction.services.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("lot")
public class LotContoller {
    @Autowired
    private LotService lotService;
    @PostMapping("/save")
    public LotDto saveLot(@Valid @RequestBody LotDto lotDto){
        lotDto.setId(1l);
        System.out.println(lotDto);
        return lotDto;
        //return lotService.saveLot(lotDto);
    }
    @GetMapping("get")
    public List<LotDto> getLots(){
        return lotService.getLotList();
    }
    @GetMapping("/getById/{id}")
    public LotDto findById(@ApiParam(value = "Id lot") @PathVariable Long id){
        LotDto lotDto=new LotDto(){
            {setId(id);
            setName("Found");
            setMinPrice(1000);
            setStep(20);
            }
        };

        return lotDto;
    }
}
