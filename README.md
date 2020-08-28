# WebGIS province

Si vuol creare un piccolo sistema webgis per pubblicare e interrogare puntualmente
i dati geospaziali delle province resi disponibili come open data da ISTAT e
scaricabili all'indirizzo (https://www.istat.it/it/archivio/222527).

I candidati dovranno realizzare, quanto almeno quanto segue:
- componente lato server in linguaggio Java, con backend su database geospaziale PostGIS;
- componente lato client in linguaggio JavaScript, con libreria di mapping OpenLayers;
- comunicazione tra le componenti tramite API REST (semplice chiamata GET).

Funzionalità minime lato server:
- costruzione del modello dati (tabella su database) opportunamente modellato a piacere (fornire SQL);
- caricamento iniziale del dato cartografico (fornire SQL);
- restituzione del dato cartografico, estratto da database, tramite chiamata HTTP GET in formato GeoJSON.

Funzionalità minime lato client:
- visualizzazione su layer vettoriale dei dati ottenuti dal server;
- visualizzazione degli attributi della feature cliccata su popup modale;
- sfondo cartografico OpenStreetMap.

Il candidato dovrà utilizzare le seguenti tecnologie server:
- Spring Boot
- Hibernate Spatial

È lasciata libertà nella scelta di eventuali framework JavaScript / UI lato client.

La consegna del lavoro avverrà con la messa a disposizione di un fork GitHub pubblico e comunicazione del link.

# Utilizzo del boilerplate

Questo boilerplate implementa già la struttura richiesta.
Al candidato è richiesto di:

- scaricare il data set dal sito web istat
- riproiettare in WGS84 (EPSG:4326) lo shapefile delle province utilizzando QGIS
- creare database e abilitare estensione spaziale postgis nello stesso
- adattare e convertire il formato shapefile per il caricamento su database postgres (in alternativa utilizzare shp2pgsql)
- estrarre i dati popolati nel db nel file webgis.sql presente nel repository 
- configurare l'applicazione in modo adeguato alla configurazione del proprio sistema 
- popolare la base di dati in funzione del model
- modificare opportunamente i controller se necessario (attenzione ai TODO)
- modificare opportunamente i service se necessario (attenzione ai TODO)
- modificare opportunamente i repository se necessario (attenzione ai TODO)
- ultimare la componente di mapping lato client modificando gli stili a piacere e ultimando la componente di interrogazione e visualizzazione su popup del dato
- comprendere le componenti già realizzate
