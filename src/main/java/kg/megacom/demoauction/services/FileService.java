package kg.megacom.demoauction.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    void  saveFile(MultipartFile multipartFile, String lotId);
}
