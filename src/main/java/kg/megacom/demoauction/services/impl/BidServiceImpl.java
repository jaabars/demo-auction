package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.BidRepository;
import kg.megacom.demoauction.database.LotRepository;
import kg.megacom.demoauction.database.StatusRepository;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.BidDto;
import kg.megacom.demoauction.model.dto.StatusDto;
import kg.megacom.demoauction.model.entity.Bid;
import kg.megacom.demoauction.model.entity.Lot;
import kg.megacom.demoauction.services.BidService;
import kg.megacom.demoauction.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private StatusRepository statusRepository;


    @Override
    public BidDto saveBid(BidDto bidDto) {
        if (bidDto.getBidValue() >= lotRepository.getOne(bidDto.getLot().getId()).getMaxPrice()) {
            System.out.println("Вы выиграли данный лот");
            StatusDto statusDto = bidDto.getLot().getStatus();
            statusDto.setId(bidDto.getLot().getStatus().getId());
            statusDto.setName("продан");
            statusRepository.save(ClassMapper.INSTANCE.statusDtoToStatus(statusDto));
            System.out.println(bidDto.getLot().getStatus().getName());


        } else if (bidDto.getBidValue() >= lotRepository.getOne(bidDto.getLot().getId()).getMinPrice()) {
            Bid bid = ClassMapper.INSTANCE.bidDtoToBid(bidDto);
            bidRepository.save(bid);
            bidDto = ClassMapper.INSTANCE.bidToBidDto(bid);
            return bidDto;
        } else if (bidDto.getBidValue() < lotRepository.getOne(bidDto.getLot().getId()).getMinPrice()) {
            System.out.println("Ставка должна быть больше MinPrice");
        }
        return null;
    }


         @Override
    public List<BidDto> getBidList() {
        List<Bid> bidList=bidRepository.findAll();
        return ClassMapper.INSTANCE.bidListToBidDtoList(bidList);
    }



}

