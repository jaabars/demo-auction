package kg.megacom.demoauction.services;

import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.dto.LotDto;
import kg.megacom.demoauction.model.entity.Bid;

import java.util.Date;
import java.util.List;

public interface BidService {
    BidDto saveBid(BidDto bidDto);
    List<BidDto> getBidList();
    boolean EndDateChecker(Date date);



}
