/*
* per costruire il db ho utilizzato il il tool fornito da postgis su database opportunatamente prediposto.
* il database si trova nel mio server personale quindi i comandi usati sono:
* create database webgis;
* \connect webgis;
* CREATE EXTENSION postgis;
* e si esce dal db. Succesivamente ho dato il comando postgis per  convertire lo shapefile in dati per il
* db :
* shp2pgsql -s 2246 ProvCM01012020_g_WGS84.shp | psql -d webgis -U postgres.
* il parametro -s è prediposto da consegna
* vengono create diverse tabelle ma al fine dell'esercizio propostomi ho rinominato la tabella che mi
* con oppurtuna query SQL :
* ALTER TABLE provCM01012020_g_WGS84
* RENAME TO provincia;
* In seguito illustro la tabella così costruita
*/
CREATE TABLE PROVINCIA
(
    gid INTEGER NOT NULL,
    cod_rip BIGINT,
    cod_reg BIGINT,
    cod_prov BIGINT,
    cod_cm BIGINT,
    cod_uts BIGINT,
    den_prov VARCHAR(50),
    den_cm VARCHAR(50),
    den_uts VARCHAR(50),
    sigla VARCHAR(2),
    tipo_uts VARCHAR(50),
    shape_area NUMERIC,
    shape_len NUMERIC,
    geom TEXT,
    PRIMARY KEY (gid)
);
