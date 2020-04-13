package kg.megacom.demoauction.controllers;

import io.swagger.annotations.Api;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bid")
@Api(value = "Bid Management System",description = "Post and get operations")
public class BidController {
    @Autowired
    private BidService bidService;
    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BidDto saveBid(@Valid @RequestBody BidDto bidDto){
        return bidService.saveBid(bidDto);
    }
    @GetMapping("/get")
    public List<BidDto> getBids(){
        return bidService.getBidList();
    }



}
