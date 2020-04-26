package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.LotRepository;
import kg.megacom.demoauction.exceptions.LotExistException;
import kg.megacom.demoauction.exceptions.LotNotFound;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.LotDto;
import kg.megacom.demoauction.model.entity.Lot;
import kg.megacom.demoauction.services.FileService;
import kg.megacom.demoauction.services.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Service
public class LotServiceImpl implements LotService {
    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private FileService fileService;
    @Override
    public LotDto saveLot(LotDto lotDto) {
        if (lotExist(lotDto.getName())){
            throw new LotExistException(lotDto.getName());
        }
        Lot lot= ClassMapper.INSTANCE.lotDtoTLot(lotDto);
        lot=lotRepository.save(lot);

        lotDto=ClassMapper.INSTANCE.lotToLotDto(lot);
        File file=lotDto.getFile();
        try {
            MultipartFile multipartFile=new MockMultipartFile(file.getName(),new FileInputStream(file.getAbsolutePath()));
          fileService.saveFile(multipartFile, lotDto.getId().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @Override
    public List<LotDto> getAciveLots() {
        String active="Активен";
        List<Lot> lots=lotRepository.findAllByStatus_Name(active);
        return ClassMapper.INSTANCE.lotListToLotDto(lots);
    }

}
