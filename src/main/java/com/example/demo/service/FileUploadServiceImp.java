package com.example.demo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.exceptions.BodyNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class FileUploadServiceImp implements IFileUploadService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ProductosServiceImp prod_service;

    @SuppressWarnings("unchecked")
    @Override
    public ProductosEntity upload(Long id, MultipartFile file_cloudinary) {
        List<String> extensionesPermitidas = Arrays.asList("jpg", "jpeg", "png", "webp", "avif");

        ProductosEntity prod = prod_service.findProductoById(id);

        String extensions = null;

        if (file_cloudinary.getOriginalFilename() != null){
            String[] dividir_nombre = file_cloudinary.getOriginalFilename().split("\\.");
            extensions = dividir_nombre[dividir_nombre.length -1];
        }
        if( !extensionesPermitidas.contains(extensions) ) throw new BodyNotValidException(
                String.format("Extension %s not allowed.", extensions)
        );

        try {
            Map<String, Object> resultUpload = cloudinary.uploader().upload(file_cloudinary.getBytes(), ObjectUtils.asMap("folder", "imagenes_negocio"));

            String imageUrl = resultUpload.get("secure_url").toString();

            prod.setFotoProducto(imageUrl);

            prod_service.PutProductos(prod);

            return prod;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
