package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.BidRepository;
import kg.megacom.demoauction.database.LotRepository;
import kg.megacom.demoauction.database.StatusRepository;
import kg.megacom.demoauction.exceptions.DateCheckLot;
import kg.megacom.demoauction.exceptions.StatusCheck;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.dto.LotDto;
import kg.megacom.demoauction.model.dto.StatusDto;
import kg.megacom.demoauction.model.entity.Bid;
import kg.megacom.demoauction.model.entity.Lot;
import kg.megacom.demoauction.model.entity.Status;
import kg.megacom.demoauction.services.BidService;
import kg.megacom.demoauction.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private LotRepository lotRepository;



    @Override
    public BidDto saveBid(BidDto bidDto) {
        Bid bid = ClassMapper.INSTANCE.bidDtoToBid(bidDto);
        bid=bidRepository.save(bid);
        bidDto = ClassMapper.INSTANCE.bidToBidDto(bid);
        return bidDto;

    }
         @Override
    public List<BidDto> getBidList() {
        List<Bid> bidList=bidRepository.findAll();
        return ClassMapper.INSTANCE.bidListToBidDtoList(bidList);
    }

    @Override
    public boolean EndDateChecker(Date date ){
        int count=lotRepository.countByEndDateGreaterThanEqual(date);
       if(count==0){
            throw new DateCheckLot(date);
       }else {
return count==1;}
    }



    }