package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.BidRepository;
import kg.megacom.demoauction.database.LotRepository;
import kg.megacom.demoauction.database.StatusRepository;
import kg.megacom.demoauction.exceptions.DateCheckLot;
import kg.megacom.demoauction.exceptions.StatusCheck;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.BidDto;
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
    @Autowired
    private StatusRepository statusRepository;


    @Override
    public BidDto saveBid(BidDto bidDto) {
       /* if (bidDto.getBidValue() >= lotRepository.getOne(bidDto.getLot().getId()).getMaxPrice()
                && EndDateChecker(bidDto.getAddDate())&&lotStatus(bidDto.getLot().getStatus().getId())==true) {

            System.out.println("Вы выиграли данный лот");
            StatusDto statusDto = bidDto.getLot().getStatus();
            statusDto.setId(bidDto.getLot().getStatus().getId());
            statusDto.setName("продан");
            Status status=new Status();
           status= statusRepository.save(ClassMapper.INSTANCE.statusDtoToStatus(statusDto));
            System.out.println(bidDto.getLot().getStatus().getName());


        } else if (bidDto.getBidValue() >= lotRepository.getOne(bidDto.getLot().getId()).getMinPrice()
                && EndDateChecker(bidDto.getAddDate())&&lotStatus(bidDto.getLot().getStatus().getId())==true) {
            Bid bid = ClassMapper.INSTANCE.bidDtoToBid(bidDto);
             bid=bidRepository.save(bid);
            bidDto = ClassMapper.INSTANCE.bidToBidDto(bid);
            return bidDto;
        } else if (bidDto.getBidValue() < lotRepository.getOne(bidDto.getLot().getId()).getMinPrice()) {
            System.out.println("Ставка должна быть больше MinPrice");
        } else {
            if (lotStatus(bidDto.getLot().getStatus().getId())==false)
                throw new StatusCheck(bidDto.getLot().getStatus().getName());
            System.out.println("false");


        }
            return null;*/
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

    @Override
    public boolean lotStatus(Long id) {
        Status status =statusRepository.getById(id);
        boolean b;
        String active="active";
        String closed="closed";
        String sold="sold";
      if (status.getName().equals(active)){
      b=true;
      return b;
      }
      else if(status.getName().equals(closed)){
          b=false;
          return b;
      }
      return false;
    }

    }