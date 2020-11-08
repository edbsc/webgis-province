package org.example.webgis.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.example.webgis.model.Provincia;
import org.example.webgis.repository.ProvinciaRepository;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;
import org.geojson.GeoJsonObjectVisitor;
import org.geojson.LngLatAlt;
import org.geojson.MultiPolygon;
import org.geojson.Polygon;
import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.metamodel.BasicType;

@Service
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(as= BasicType.class)
public class ProvinciaService {


    private ProvinciaRepository provinciaRepository;
    
    public ProvinciaRepository getProvinciaRepository() {
        return provinciaRepository;
    }

    @Autowired
    public void setProvinciaRepository(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    public List<Provincia> listProvince() {
        return getProvinciaRepository().findAll();
    }
    
    public String listProvinceGeojson() {
        final FeatureCollection featureCollection = new FeatureCollection();


        listProvince().stream().forEach(p -> {
           final Feature feature = new Feature();
            feature.setId(p.getId().toString());
            feature.setProperties(p.getPropertyMap());
            feature.setGeometry(convertGeometry(p.getGeom()));
            //GeoJsonObject prova = convertGeometry(p.getGeom());
            // feature.setGeometry(convertGeometry(p.getGeom()));
            featureCollection.add(feature);
        });

        try {

           return new ObjectMapper().writeValueAsString(featureCollection);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }

    private GeoJsonObject convertGeometry(Geometry geom) {
        if (geom != null) {
            if (geom instanceof org.locationtech.jts.geom.MultiPolygon) {
                final org.locationtech.jts.geom.MultiPolygon jtsMultiPolygon = (org.locationtech.jts.geom.MultiPolygon)geom;
                final int geomNumber = jtsMultiPolygon.getNumGeometries();
                //jtsMultiPolygon.reverse();
                //System.out.println(geomNumber);
                final MultiPolygon mp = new MultiPolygon();
                for (int i = 0; i < geomNumber; i++) {
                    final org.locationtech.jts.geom.Polygon jtsPolygon = (org.locationtech.jts.geom.Polygon)jtsMultiPolygon.getGeometryN(i);
                    final Polygon p = new Polygon();
                    p.setExteriorRing(Arrays.stream(jtsPolygon.getExteriorRing().getCoordinates()).map(c -> {
                        return new LngLatAlt(c.x, c.y, c.getZ());
                    }).collect(Collectors.toList()));
                    // TODO (OPTIONAL) add inner rings to show the understanding of OGC simple features and GeoJSON

                    mp.add(p);
                }


                return mp;
            }
        }
        return null;
    }

}
