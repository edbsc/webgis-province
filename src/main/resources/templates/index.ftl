<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>WebGIS</title>
  <meta name="description" content="WebGIS">
  <meta name="author" content="3DGIS">
	<style>
		html, body, #map {
			padding: 0;
			margin: 0;
			height: 100%;
			width: 100%;
		}
	</style>
</head>

<body>
	<div id="map"></div>
	<script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.4.3/build/ol.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.4.3/css/ol.css">
	<script>
		var vectorLayer = new ol.layer.Vector({
	  		source: new ol.source.Vector({
	    		url: '/province/list',
	    		projection: "EPSG:4326",
	    		format: new ol.format.GeoJSON(),
	  		}),
	  		style: new ol.style.Style({
                    stroke: new ol.style.Stroke({
                        color: 'blue',
                        width: 300
                    })
                })
        });

	  var map = new ol.Map({
	    target: 'map',
	    layers: [
	      new ol.layer.Tile({
	        source: new ol.source.OSM()
	      }),
	      vectorLayer
	    ],
	    view: new ol.View({
	      center: ol.proj.fromLonLat([12, 40.82]),
	      zoom: 6
	    })
	  });
	</script>
</body>
</html>