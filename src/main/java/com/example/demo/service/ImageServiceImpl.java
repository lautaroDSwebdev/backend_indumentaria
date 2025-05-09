package com.example.demo.service;

import com.example.demo.entity.ImageEntity;
import com.example.demo.repo.IFotoRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IFotoService{

    @Autowired
    private CloudinaryService cl_service;

    @Autowired
    private IFotoRepo image_repo;


    @Override
    public ImageEntity uploadImage(MultipartFile file) throws IOException {
        Map uploadResult = cl_service.upload(file);
        String imageUrl = (String) uploadResult.get("url");
        String imageId = (String) uploadResult.get("public_id");
        ImageEntity image = new ImageEntity(file.getOriginalFilename(), imageUrl, imageId);
        return image_repo.save(image);
    }

    @Override
    public void deleteImage(ImageEntity img) throws IOException {
        cl_service.delete(img.getImageId());
        image_repo.deleteById(img.getId_image());
    }
}
