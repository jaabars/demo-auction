package kg.megacom.demoauction.services;

import kg.megacom.demoauction.model.dto.LotDto;

import java.util.List;

public interface LotService {

    LotDto saveLot(LotDto lotDto);
    List<LotDto> getLotList();
    LotDto findLotById(Long id);
    boolean lotExist(String name);
    List<LotDto> getAciveLots();

}
