package org.example.webgis.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.locationtech.jts.geom.Geometry;

@Entity
public class Provincia {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        columnDefinition = "SERIAL"
    )
    private Integer gid;
    private Long cod_rip;
    private Long cod_reg;
    private Long cod_prov;
    private Long cod_cm;
    private Long cod_uts;
    private String den_prov;
    private String den_cm;
    private String den_uts;
    private String sigla;
    private String tipo_uts;
    private BigDecimal shape_area;
    private BigDecimal shape_len;
    private Geometry geom;

    
    
    public Integer getId() {
        return gid;
    }

    public void setId(Integer id) {
        this.gid = id;
    }

    public Long getCodRip() {
        return cod_rip;
    }

    public void setCodRip(Long codRip) {
        this.cod_rip = codRip;
    }

    public Long getCodReg() {
        return cod_reg;
    }

    public void setCodReg(Long codReg) {
        this.cod_reg = codReg;
    }

    public Long getCodProv() {
        return cod_prov;
    }

    public void setCodProv(Long codProv) {
        this.cod_prov = codProv;
    }

    public Long getCodCm() {
        return cod_cm;
    }

    public void setCodCm(Long codCm) {
        this.cod_cm = codCm;
    }

    public Long getCodUts() {
        return cod_uts;
    }

    public void setCodUts(Long codUts) {
        this.cod_uts = codUts;
    }

    public String getDenProv() {
        return den_prov;
    }

    public void setDenProv(String denProv) {
        this.den_prov = denProv;
    }

    public String getDenCm() {
        return den_cm;
    }

    public void setDenCm(String denCm) {
        this.den_cm = denCm;
    }

    public String getDenUts() {
        return den_uts;
    }

    public void setDenUts(String denUts) {
        this.den_uts = denUts;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTipoUts() {
        return tipo_uts;
    }

    public void setTipoUts(String tipoUts) {
        this.tipo_uts = tipoUts;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    public BigDecimal getShapeArea() {
        return shape_area;
    }

    public void setShapeArea(BigDecimal shapeArea) {
        this.shape_area = shapeArea;
    }

    public BigDecimal getShapeLen() {
        return shape_len;
    }

    public void setShapeLen(BigDecimal shapeLen) {
        this.shape_len= shapeLen;
    }

    public Map<String, Object> getPropertyMap() {
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", this.getId());
        map.put("codRip", this.getCodRip());
        map.put("codProv", this.getCodProv());
        map.put("codCm", this.getCodCm());
        map.put("codUts", this.getCodUts());
        map.put("denProv", this.getDenProv());
        map.put("denCm", this.getDenCm());
        map.put("denUts", this.getDenUts());
        map.put("sigla", this.getSigla());
        map.put("tipoUts", this.getTipoUts());
        map.put("shapeArea", this.getShapeArea());
        map.put("shapeLen", this.getShapeLen());
        return map;
    }
    
    

}
