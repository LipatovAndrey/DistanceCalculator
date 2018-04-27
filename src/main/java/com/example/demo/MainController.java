package com.example.demo;

import com.example.demo.domain.Camera;
import com.example.demo.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
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
        Iterable<Camera> cameras = serviceGetRegisterCams.getRegisterCams();
        for (Camera c: cameras
             ) {
            log.info("--------------------------");
            log.info(serviceGetParams.getNameById(c.getId()));
            log.info(String.valueOf("Количество фотографий на 200х200 метров "+serviceNumberOfPhoto.getNumberOfPhoto(serviceDistanceBetweenPhoto.distanceBetweenPointsX(8,150,30.0),
                    serviceDistanceBetweenPhoto.distanceBetweenPointsY(c.getId(),150,30.0),
                    200.0, 200.0)));
            log.info(String.valueOf("длина в метрах "+ serviceGetParams.getLengthPeaceOfLandById(c.getId(), 150)));
            log.info(String.valueOf("ширина в метрах "+ serviceGetParams.getWidthPeaceOfLandById(c.getId(), 150)));
            log.info(String.valueOf("Площадь в кв. метрах "+ serviceGetParams.getSquerInMetres(c.getId(), 150)));
            log.info(String.valueOf("Площадь в кв. Киллометрах "+ serviceGetParams.getSquerInKMetres(c.getId(), 150)));
            log.info(String.valueOf("Разрешение "+ serviceGetParams.getResolution(c.getId(),150))+" Сантиметров в одном пикселе");
            log.info("--------------------------");
        }


        model.put("cameras", cameras);
        return "show";
    }



    @PostMapping
    public String addCamera(@RequestParam String name, String brand, String sensorWidth, String sensorHeight, String fokalLength, String imgWidthPx,
                            String imgHeightPx,  Map<String, Object> model){

        serviceRegister.registerNewCam(name, brand, sensorWidth, sensorHeight, fokalLength, imgWidthPx, imgHeightPx);
        model.put("cameras", serviceGetRegisterCams);
        return "show";
    }




}