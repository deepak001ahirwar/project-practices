package com.file.demo.database;

import com.file.demo.comman.FileServiceInterface;
import com.file.demo.database.pojo.ImageData;
import com.file.demo.database.repo.ImageDataRepo;
import com.file.demo.fileSystem.pojo.FilesData;
import com.file.demo.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
@Service
@ConditionalOnProperty(value = "app.service.file.mode",havingValue = "DB")
public class DBService implements FileServiceInterface {


    @Autowired
    ImageDataRepo imageDataRepo;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        // use compression the store in DB
        ImageData datafile = imageDataRepo.save(ImageData.builder().name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());

        if (datafile != null) {
            System.out.println("File Sucessfully Stored in DB: " + file.getOriginalFilename());
            return "File Sucessfully Stored in DB: " + file.getOriginalFilename();
        }
        return null;
    }

    @Override
    public byte[] downloadfile(String fileName) throws IOException {
        // use decompresion in then
        Optional<ImageData> imageData = imageDataRepo.findByName(fileName);

        byte[] images = ImageUtils.decompressImage(imageData.get().getImageData());
        if (images != null) {
            System.out.println("File has been download sucessfully from DB: " + fileName);
        }
        return images;
    }
}
