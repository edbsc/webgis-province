/*
* per costruire il db ho utilizzato il il tool fornito da postgis su database opportunatamente prediposto.
* il database si trova nel mio server personale quindi i comandi usati sono:
* create database webgis;
* \connect webgis;
* CREATE EXTENSION postgis;
* e si esce dal db. Succesivamente ho dato il comando postgis per  convertire lo shapefile in dati per il
* db :
* shp2pgsql ProvCM01012020_g_WGS84.shp | psql -d webgis -U postgres.
*
* vengono create diverse tabelle ma al fine dell'esercizio propostomi ho rinominato la tabella che mi
* con oppurtuna query SQL :
* ALTER TABLE provCM01012020_g_WGS84
* RENAME TO provincia;
* In seguito illustro la tabella così costruita
*/
CREATE TABLE PROVINCIA
(
    gid INTEGER NOT NULL,
    cod_rip INT,
    cod_reg SMALLINT,
    cod_prov SMALLINT,
    cod_cm SMALLINT,
    cod_uts SMALLINT,
    den_prov VARCHAR(21),
    den_cm VARCHAR(18),
    den_uts VARCHAR(21),
    sigla VARCHAR(2),
    tipo_uts VARCHAR(26),
    shape_area NUMERIC,
    shape_len NUMERIC,
    geom BOX,
    PRIMARY KEY (gid)
);
