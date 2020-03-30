package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.LotRepository;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.LotDto;
import kg.megacom.demoauction.model.entity.Lot;
import kg.megacom.demoauction.services.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LotServiceImpl implements LotService {
    @Autowired
    private LotRepository lotRepository;
    @Override
    public LotDto saveLot(LotDto lotDto) {
        Lot lot= ClassMapper.INSTANCE.lotDtoTLot(lotDto);
        lotRepository.save(lot);
        lotDto=ClassMapper.INSTANCE.lotToLotDto(lot);
        return lotDto;
    }

    @Override
    public List<LotDto> getLotList() {
        List<Lot> lotList=lotRepository.findAll();
        return ClassMapper.INSTANCE.lotListToLotDto(lotList);
    }
}
