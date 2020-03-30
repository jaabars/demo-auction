package kg.megacom.demoauction.controllers;

import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bid")
public class BidController {
    @Autowired
    private BidService bidService;
    @PostMapping("/save")
    public BidDto saveBid(@RequestBody BidDto bidDto){
        return bidService.saveBid(bidDto);
    }
    @GetMapping("/get")
    public List<BidDto> getBids(){
        return bidService.getBidList();
    }



}
