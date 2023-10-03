package com.file.demo.fileSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FileData_System")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilesData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long imgId;
    private String name;

    private String type;

    private String path;


}
