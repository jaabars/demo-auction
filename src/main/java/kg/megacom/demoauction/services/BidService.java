package kg.megacom.demoauction.services;

import kg.megacom.demoauction.model.dto.BidDto;

import java.util.List;

public interface BidService {
    BidDto saveBid(BidDto bidDto);
    List<BidDto> getBidList();
}
