package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.BidRepository;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.entity.Bid;
import kg.megacom.demoauction.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;

    @Override
    public BidDto saveBid(BidDto bidDto) {
        Bid bid =ClassMapper.INSTANCE.bidDtoToBid(bidDto);
        bidRepository.save(bid);
         bidDto=ClassMapper.INSTANCE.bidToBidDto(bid);
         return bidDto;
    }

    @Override
    public List<BidDto> getBidList() {
        List<Bid> bidList=bidRepository.findAll();
        return ClassMapper.INSTANCE.bidListToBidDtoList(bidList);
    }
}
