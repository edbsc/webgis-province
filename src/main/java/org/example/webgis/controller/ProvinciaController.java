package org.example.webgis.controller;

import org.example.webgis.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvinciaController {
    private ProvinciaService provinciaService;

    public ProvinciaService getProvinciaService() {
        return provinciaService;
    }

    @Autowired
    public void setProvinciaService(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }
    
    @GetMapping(value = "/province/list", produces = "application/json")
    public String data() {
        // TODO retrieve geojson from service
        return provinciaService.listProvinceGeojson();
        //return "{}";
    }
}
