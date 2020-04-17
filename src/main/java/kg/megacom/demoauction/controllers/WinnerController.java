package kg.megacom.demoauction.controllers;

import kg.megacom.demoauction.database.BidRepository;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.entity.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/winner")
public class WinnerController {
    @Autowired
    private BidRepository bidRepository;
    @PostMapping("/getwinner")
    public BidDto getWinner(List<Bid> bidlist){
        BidDto bidDto=new BidDto();
        return bidDto;
    }


}
