package com.file.demo.database.repo;

import com.file.demo.comman.FileServiceInterface;
import com.file.demo.database.pojo.ImageData;
import com.file.demo.fileSystem.pojo.FilesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDataRepo extends JpaRepository<ImageData,Integer> {

    // findby Name
    Optional<ImageData> findByName(String fileName);
}
