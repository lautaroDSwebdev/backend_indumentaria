package com.example.demo.service;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name", "doiadjnku");
        valuesMap.put("api_key", "699854389694996");
        valuesMap.put("api_secret", "LeM9EYBvoay3V2D3sjjv6YNX-WA");
        cloudinary = new Cloudinary(valuesMap);
    }


    @Override
    public Map upload(MultipartFile multipartFile) throws IOException {
        return Map.of();
    }

    @Override
    public Map delete(String id) throws IOException {
        return Map.of();
    }
}