package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.LotRepository;
import kg.megacom.demoauction.exceptions.LotExistException;
import kg.megacom.demoauction.exceptions.LotNotFound;
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
        if (lotExist(lotDto.getName())){
            throw new LotExistException(lotDto.getName());
        }
        Lot lot= ClassMapper.INSTANCE.lotDtoTLot(lotDto);
        lot=lotRepository.save(lot);
        lotDto=ClassMapper.INSTANCE.lotToLotDto(lot);
        return lotDto;
    }

    @Override
    public List<LotDto> getLotList() {
        List<Lot> lotList=lotRepository.findAll();
        return ClassMapper.INSTANCE.lotListToLotDto(lotList);
    }

    @Override
    public LotDto findLotById(Long id) {
        Lot lot=lotRepository.findById(id).orElse(null);
        if (lot==null){
            throw new LotNotFound("Лот не найден");
        }
        LotDto lotDto=ClassMapper.INSTANCE.lotToLotDto(lot);
        return lotDto;
    }

    @Override
    public boolean lotExist(String name) {
        int count=lotRepository.countByName(name);
        return count==1;

    }
}
