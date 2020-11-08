package org.example.webgis.controller;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.example.webgis.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

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
        //get local copy of geojson for debug
        try
        {
            FileWriter json = new FileWriter("vector.geojson");
            json.write(provinciaService.listProvinceGeojson());
            json.close();

        }
        catch (IOException e)
        {

        }


        return provinciaService.listProvinceGeojson();
        //return "{}";
    }
}
