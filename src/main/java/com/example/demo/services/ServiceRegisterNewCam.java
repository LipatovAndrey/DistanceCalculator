package com.example.demo.services;

import com.example.demo.domain.Camera;
import com.example.demo.repos.CameraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegisterNewCam {

    @Autowired
    private CameraRepo cameraRepo;


    public void registerNewCam(String name, String brand, String sensorWidth, String sensorHeight, String fokalLength,
                               String imgWidthPx, String imgHeightPx) {
        Camera camera = new Camera(name, brand, sensorWidth, sensorHeight, fokalLength, imgWidthPx, imgHeightPx);
        cameraRepo.save(camera);
    }
}


