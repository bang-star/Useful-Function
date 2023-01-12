package com.example.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 이미지를 DB에 저장하는 방식
 */

@Getter
@Entity
@Table(name = "ImageData")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) private String name;

    private String type;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    @Builder
    public ImageData(String name, String type, byte[] imageData){
        this.name = name;
        this.type = type;
        this.imageData = imageData;
    }
}
