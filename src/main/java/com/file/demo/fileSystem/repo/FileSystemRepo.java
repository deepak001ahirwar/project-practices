package com.file.demo.fileSystem.repo;

import com.file.demo.fileSystem.pojo.FilesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileSystemRepo  extends JpaRepository<FilesData,Integer> {

    // findby Name
    Optional<FilesData> findByName(String fileName);
}
