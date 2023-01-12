package com.example.service;

import com.example.entity.FileData;
import com.example.entity.ImageData;
import com.example.repository.FileDataRepository;
import com.example.repository.StorageRepository;
import com.example.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Service
@RequiredArgsConstructor
public class StorageService {

    private final String IMAGE_SAVE_PATH = this.getClass().getResource("").toString();

    private final StorageRepository storageRepository;
    private final FileDataRepository fileDataRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        log.info("uploaded file: {}", file);

        ImageData imageData = storageRepository.save(
                ImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                        .build()
        );

        if(imageData != null){
            log.info("imageData: {}", imageData);
            return "file uploaded successfully : " + file.getOriginalFilename();
        }

        return "file upload failed.";
    }

    // 이미지 파일로 압축하기
    public byte[] downloadImage(String fileName) {
        ImageData imageData = storageRepository.findByName(fileName)
                .orElseThrow(RuntimeException::new);

        log.info("download imageData: {}", imageData);

        return ImageUtils.decompressImage(imageData.getImageData());
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        log.info("uploaded file: {}", file.getOriginalFilename());

        String filePath = IMAGE_SAVE_PATH + file.getOriginalFilename();

        FileData fileData = fileDataRepository.save(
                FileData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .filePath(filePath)
                        .build()
        );

        file.transferTo(new File(filePath));

        if(fileData != null){
            return "file uploaded successfully! FilePath: " + filePath;
        }

        return "file upload failed.";
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        System.out.println("CurPath: "+this.getClass().getResource(""));

        FileData fileData = fileDataRepository.findByName(fileName)
                .orElseThrow(RuntimeException::new);

        String filePath = fileData.getFilePath();

        log.info("download fileData: {}", fileData);
        log.info("download filePath: {}", filePath);

        return Files.readAllBytes(new File(filePath).toPath());
    }

}
