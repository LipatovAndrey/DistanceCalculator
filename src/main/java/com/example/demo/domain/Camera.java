package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Camera {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String brand;

    private Float sensorWidth;

    private Float sensorHeight;

    private Float  fokalLength;

    private Integer imgWidthPx;

    private Integer imgHeightPx;

    private Float resolution;



    public Camera() {
    }

    public Camera(String name, String brand, String sensorWidth, String sensorHeight, String fokalLength,
                  String imgWidthPx, String imgHeightPx) {
        this.name = name;
        this.brand = brand;
        this.sensorWidth = Float.valueOf(sensorWidth);
        this.sensorHeight = Float.valueOf(sensorHeight);
        this.fokalLength = Float.valueOf(fokalLength);
        this.imgWidthPx = Integer.valueOf(imgWidthPx);
        this.imgHeightPx = Integer.valueOf(imgHeightPx);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public Float getSensorHeight() {
        return sensorHeight;
    }

    public void setSensorHeight(Float sensorHeight) {
        this.sensorHeight = sensorHeight;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getSensorWidth() {
        return sensorWidth;
    }

    public void setSensorWidth(Float sensorWidth) {
        this.sensorWidth = sensorWidth;
    }

    public Float getFokalLength() {
        return fokalLength;
    }

    public void setFokalLength(Float fokalLength) {
        this.fokalLength = fokalLength;
    }


    public Integer getImgWidthPx() {
        return imgWidthPx;
    }

    public void setImgWidthPx(Integer imgWidthPx) {
        this.imgWidthPx = imgWidthPx;
    }

    public Integer getImgHeightPx() {
        return imgHeightPx;
    }

    public void setImgHeightPx(Integer imgHeightPx) {
        this.imgHeightPx = imgHeightPx;
    }

    public Float getResolution() {
        return resolution;
    }

    public void setResolution(Float resolution) {
        this.resolution = resolution;
    }


}