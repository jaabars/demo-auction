package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.StatusRepository;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.StatusDto;
import kg.megacom.demoauction.model.entity.Status;
import kg.megacom.demoauction.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;
    @Override
    public StatusDto saveStatus(StatusDto statusDto) {
        Status status= ClassMapper.INSTANCE.statusDtoToStatus(statusDto);
        status=statusRepository.save(status);
        statusDto=ClassMapper.INSTANCE.statusToStatusDto(status);
        return statusDto;
    }

    @Override
    public List<StatusDto> getStatusList() {
        List<Status> statusList=statusRepository.findAll();

        return ClassMapper.INSTANCE.statusListToStatusDtoList(statusList);
    }

  /*  @Override
    public List<StatusDto> getStatusList(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        return ClassMapper.INSTANCE.statusListToStatusDtoList(statusRepository.findStatusesBy(pageable));
    }*/
}
