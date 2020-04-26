package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

@Service
public class FileServiceImpl implements FileService {
    @Value("${img.path}")
    private String dirPath;
    @Override
    public void saveFile(MultipartFile multipartFile, String lotId) {

        Path path= Paths.get(dirPath+"/"+lotId);
        if (!Files.exists(path)){
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        path=Paths.get(path+"/"+multipartFile.getName());


        try {
            Files.write(path, multipartFile.getBytes());
            System.out.println(Files.getFileStore(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
