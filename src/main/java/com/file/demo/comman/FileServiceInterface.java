package com.file.demo.comman;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Component
public interface FileServiceInterface {


    // upload the file
    public String uploadFile(MultipartFile file) throws IOException;


    // download the file

    public  byte[] downloadfile(String fileName) throws IOException;


}
