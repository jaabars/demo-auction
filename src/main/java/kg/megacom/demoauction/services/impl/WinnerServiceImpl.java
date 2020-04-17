package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.entity.Bid;
import kg.megacom.demoauction.services.WinnerService;

import java.util.Comparator;
import java.util.List;

public class WinnerServiceImpl implements WinnerService {
    @Override
    public BidDto getWinner(List<Bid> bids) {
       Bid bid1=bids.stream().max(Comparator.comparing(Bid::getBidValue)).get();
       BidDto bidDto= ClassMapper.INSTANCE.bidToBidDto(bid1);


        return bidDto;
    }
}
