package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.domain.Camera;
import com.example.demo.repos.CameraRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDistanceBetweenPhoto {


    @Autowired
    private  ServiceGetParams serviceGetParams;

    public Double distanceBetweenPointsX(Integer id, Integer flyHeight, Double percentOverlapX){
        return serviceGetParams.getLengthPeaceOfLandById(id, flyHeight)*((100-percentOverlapX)/100);
    }
    public Double distanceBetweenPointsY(Integer id, Integer flyHeight, Double percentOverlapY){
        return serviceGetParams.getWidthPeaceOfLandById(id, flyHeight)* ((100-percentOverlapY)/100);
    }

}