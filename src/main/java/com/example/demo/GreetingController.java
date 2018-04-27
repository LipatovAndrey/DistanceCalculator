package com.example.demo;

import com.example.demo.domain.Camera;
import com.example.demo.repos.CameraRepo;
import com.example.demo.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);


    @Autowired
    private ServiceDistanceBetweenPhoto serviceDistanceBetweenPhoto;

    @Autowired
    private ServiceRegisterNewCam serviceRegister;

    @Autowired
    private ServiceGetRegisterCams serviceGetRegisterCams;

    @Autowired
    private ServiceGetParams serviceGetParams;

    @Autowired
    private ServiceNumberOfPhoto serviceNumberOfPhoto;


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        log.info(serviceGetParams.getNameById(8));
        log.info(String.valueOf(serviceGetParams.getLengthPeaceOfLandById(8, 150)));
        log.info(String.valueOf(serviceGetParams.getWidthPeaceOfLandById(8, 150)));
        log.info(String.valueOf(serviceDistanceBetweenPhoto.distanceBetweenPointsX(8,150,30.0)));
        log.info(String.valueOf(serviceNumberOfPhoto.getNumberOfPhoto(serviceDistanceBetweenPhoto.distanceBetweenPointsX(8,150,30.0),
                serviceDistanceBetweenPhoto.distanceBetweenPointsY(8,150,30.0),
                200.0, 200.0)));

        log.info(String.valueOf(serviceGetParams.getSquerInMetres(8, 150)));
        model.put("cameras", serviceGetRegisterCams.getRegisterCams());
        return "greeting";
    }



    @PostMapping
    public String addCamera(@RequestParam String name, String brand, String sensorWidth, String sensorHeight, String fokalLength, String imgWidthPx,
                            String imgHeightPx,  Map<String, Object> model){

        serviceRegister.registerNewCam(name, brand, sensorWidth, sensorHeight, fokalLength, imgWidthPx, imgHeightPx);
        model.put("cameras", serviceGetRegisterCams);


        return "greeting";
    }




}