package kg.megacom.demoauction.services;

import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.entity.Bid;

import java.util.List;

public interface WinnerService {
    BidDto getWinner(List<Bid> bids);
}
