package com.file.demo.database.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ImageData_DB")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    // use to reduce the size of obj
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;

}
