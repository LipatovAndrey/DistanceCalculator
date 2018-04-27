package com.example.demo.services;

import com.example.demo.domain.Camera;
import com.example.demo.repos.CameraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceGetParams{

    @Autowired
    private CameraRepo cameraRepo;


    public String  getNameById(Integer id) {
        Camera camera = cameraRepo.findById(id);
        return camera.getName();
    }
    public String  getBrandById(Integer id) {
        Camera camera = cameraRepo.findById(id);
        return camera.getBrand();
    }

    public Float  getFokalLengthById(Integer id) {
        Camera camera = cameraRepo.findById(id);
        return camera.getFokalLength();
    }

    public Float  getResolutionById(Integer id) {
        Camera camera = cameraRepo.findById(id);
        return camera.getResolution();
    }
    public Float  getSensorWidthById(Integer id) {
        Camera camera = cameraRepo.findById(id);
        return camera.getSensorWidth();
    }
    public Float  getSensorHeightById(Integer id) {
        Camera camera = cameraRepo.findById(id);
        return camera.getSensorHeight();
    }

    public Integer  getImgHeightPxById(Integer id) {
        Camera camera = cameraRepo.findById(id);
        return camera.getImgHeightPx();
    }
    public Integer  getImgWidthPxById(Integer id) {
        Camera camera = cameraRepo.findById(id);
        return camera.getImgWidthPx();
    }

    public Integer  getIdByName(String name) {
        Camera camera = cameraRepo.findByName(name);
        return camera.getId();
    }
    public String  getBrandByName(String name) {
        Camera camera = cameraRepo.findByName(name);
        return camera.getBrand();
    }

    public Float  getFokalLengthByName(String name) {
        Camera camera = cameraRepo.findByName(name);
        return camera.getFokalLength();
    }

    public Float  getResolutionByName(String name) {
        Camera camera = cameraRepo.findByName(name);
        return camera.getResolution();
    }
    public Float  getSensorWidthByName(String name) {
        Camera camera = cameraRepo.findByName(name);
        return camera.getSensorWidth();
    }
    public Float  getSensorHeightByName(String name) {
        Camera camera = cameraRepo.findByName(name);
        return camera.getSensorHeight();
    }
    public Integer  getImgHeightPxByName(String name) {
        Camera camera = cameraRepo.findByName(name);
        return camera.getImgHeightPx();
    }
    public Integer  getImgWidthPxByName(String name) {
        Camera camera = cameraRepo.findByName(name);
        return camera.getImgWidthPx();
    }

    public Double getLengthPeaceOfLandById(Integer id, Integer flyHeight) {
        Camera camera = cameraRepo.findById(id);
        Float sw = camera.getSensorWidth();
        Float fr = camera.getFokalLength();
        Double dw = (flyHeight * Math.tan(Math.atan( (sw/2) /  fr ))*2);
        return dw;
    }

    public Double getWidthPeaceOfLandById(Integer id, Integer flyHeight) {
        Camera camera = cameraRepo.findById(id);
        Float sh = camera.getSensorHeight();
        Float fr = camera.getFokalLength();
        Double dh = (flyHeight * Math.tan(Math.atan( (sh/2) /  fr ))*2);
        return dh;
    }

    public Double getSquerInMetres(Integer id, Integer flyHeight) {
        Double squer = (getLengthPeaceOfLandById(id, flyHeight)*getWidthPeaceOfLandById(id, flyHeight));
        return squer;
    }
    public Double getSquerInKMetres(Integer id, Integer flyHeight) {
        Double squer = getSquerInMetres(id, flyHeight) /1000000;
        return squer;
    }
    public Double getResolution(Integer id, Integer flyHeight) {
        return (getLengthPeaceOfLandById(id, flyHeight) * 10)/ getImgWidthPxById(id);

    }
}