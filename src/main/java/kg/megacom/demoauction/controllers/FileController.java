package kg.megacom.demoauction.controllers;

import kg.megacom.demoauction.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;
    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile multipartFile, @RequestParam(name ="lot") String lotId){
        fileService.saveFile(multipartFile,lotId);
    }

}
