package kg.megacom.demoauction.services;

import kg.megacom.demoauction.model.dto.StatusDto;

import java.util.List;

public interface StatusService {
    StatusDto saveStatus (StatusDto statusDto);
    List<StatusDto> getStatusList();
    //List<StatusDto> getStatusList(Integer pageNo, Integer pageSize, String sortBy);



}
