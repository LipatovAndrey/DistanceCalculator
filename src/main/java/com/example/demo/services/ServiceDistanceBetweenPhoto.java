package com.example.demo.services;


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
        return serviceGetParams.getWidthPeaceOfLandById(id, flyHeight)*((100-percentOverlapY)/100);
    }

    public Double distanceBetweenPointsXParams(Float sensorWidth, Float fokalLength, Integer flyHeight, Double percentOverlapX){
        Double dw = (flyHeight * Math.tan(Math.atan( (sensorWidth/2) /  fokalLength ))*2);
        return dw*((100-percentOverlapX)/100);
    }
    public Double distanceBetweenPointsYParams(Float sensorHeight, Float fokalLength, Integer flyHeight, Double percentOverlapY){
        Double dw = (flyHeight * Math.tan(Math.atan( (sensorHeight/2) /  fokalLength ))*2);
        return dw*((100-percentOverlapY)/100);
    }

}