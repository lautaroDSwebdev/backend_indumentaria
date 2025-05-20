//package com.example.demo.service;
//
//import com.example.demo.entity.CompradorEntity;
//import com.example.demo.entity.ProveedorEntity;
//import com.example.demo.repo.IProveedorRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProveedorServiceImpl implements IProveedorService {
//
//    @Autowired
//    private IProveedorRepo iprov_repo;
//
//
//    @Override
//    public List<ProveedorEntity> getProveedor() {
//        List<ProveedorEntity> get_prov = iprov_repo.findAll();
//        return get_prov;
//    }
//
//    @Override
//    public void DeleteProveedor(Long id) {
//        iprov_repo.deleteById(id);
//    }
//
//    @Override
//    public void PostProveedor(ProveedorEntity e) {
//        iprov_repo.save(e);
//    }
//
//    @Override
//    public void PutProveedor(ProveedorEntity e) {
//        this.PostProveedor(e);
//    }
//
//    @Override
//    public ProveedorEntity findProveedor(Long id) {
//        ProveedorEntity find_prov = iprov_repo.findById(id).orElse(null);
//        return find_prov;
//    }
//}
