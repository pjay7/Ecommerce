package com.ecommerce.project.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //filename of the original file
        String originalFilename = file.getOriginalFilename();

        //Generate a unique filename
        String randomId = UUID.randomUUID().toString();
        String filename = randomId.concat(originalFilename.substring(originalFilename.lastIndexOf('.'))); // Eg.: randomid.jpg
        String filepath = path + File.separator + filename;

        //check if path exist and create
        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdir();
        }

        //upload to server
        Files.copy(file.getInputStream(), Paths.get(filepath));

        return filename;
    }
}
