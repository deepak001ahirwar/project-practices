package com.file.demo.fileSystem;

import com.file.demo.comman.FileServiceInterface;
import com.file.demo.fileSystem.pojo.FilesData;
import com.file.demo.fileSystem.repo.FileSystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
@Service
@ConditionalOnProperty(value = "app.service.file.mode",havingValue = "FileSystem",matchIfMissing = true)
public class FileSystemService implements FileServiceInterface {



    @Autowired
    private FileSystemRepo fileRepo;

    @Value("${app.file.path}")
    public String filepath;
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String file_location = filepath + file.getOriginalFilename();
        FilesData savedFile = fileRepo.save(FilesData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .path(file_location)
                .build());

        // store file in local file system location

        file.transferTo(new File(file_location));

        if (savedFile != null) {
            System.out.println("file has been store sucessfully  in fileSystem: " + file_location);
            return "file has been store sucessfully  in fileSystem: " + file_location;
        }
        return null;
    }

    @Override
    public byte[] downloadfile(String fileName) throws IOException {
        Optional< FilesData> fileData = fileRepo.findByName(fileName);
        String filePath = fileData.get().getPath();
        // read file from path
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        // Files.readAllBytes(filePath)
        if (images != null) {
            System.out.println("File has been download from FileSystem: " + fileName);
        }
        return images;    }
}
