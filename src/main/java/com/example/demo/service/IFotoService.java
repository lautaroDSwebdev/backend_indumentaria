package com.example.demo.service;

import com.example.demo.entity.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFotoService {
    ImageEntity uploadImage(MultipartFile file) throws IOException;
    void deleteImage(ImageEntity img ) throws IOException;
}
