package com.bilal.catZone.services;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class AbstractImageComponent {

    public File convertAndSave(MultipartFile uploadFile , String newFileName , String appProperty){
        File file = null;
        try{
            byte[] imageInBytes = uploadFile.getBytes();
            file = new File(appProperty + "/" + newFileName + ".jpg");
            Files.write(Paths.get(file.toURI()),imageInBytes);
        }catch (Exception E){
            E.printStackTrace();
        }
        return file;
    }

    public boolean validateImageFile(MultipartFile fileToUpload){
        List<String> imageTypes = List.of("jpg","jpeg","png");
        for(String type : imageTypes){
            if(fileToUpload.getOriginalFilename().split("\\.")[1].equalsIgnoreCase(type)){
                return true;
            }
        }
        return false;
    }


}
