package com.example.demo.service;

import com.example.demo.entity.ProductosEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {
    ProductosEntity upload(Long id, MultipartFile file_cloudinary);
}
