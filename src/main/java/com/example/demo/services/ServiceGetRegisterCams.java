package com.example.demo.services;

import com.example.demo.domain.Camera;
import com.example.demo.repos.CameraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetRegisterCams{

    @Autowired
    private CameraRepo cameraRepo;


    public Iterable<Camera> getRegisterCams() {
        Iterable<Camera> cameras = cameraRepo.findAll();
        return cameras;
    }
}