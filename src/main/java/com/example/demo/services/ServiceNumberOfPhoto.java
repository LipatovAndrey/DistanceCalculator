package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class ServiceNumberOfPhoto {
    public int getNumberOfPhoto(Double distanceBetweenPointsX, Double distanceBetweenPointsY, Double regionWidth, Double regionLength){
    return (int)(Math.ceil((regionWidth / distanceBetweenPointsX)) * Math.ceil((regionLength / distanceBetweenPointsY)));
    }
}
