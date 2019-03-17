# Documentación
**Autores:**
- José Eduardo Eguiguren
- María José Mora
## Extractor de plataformas CKAN

Repo: [link](https://github.com/JamesJose7/gov-ld)

El extractor de plataformas CKAN se encarga de recorrer a través de la estructura de datos de la plataforma seleccionada y convertir esos datos en tripletas. Las tripletas son construidas en base al siguiente modelo semántico.

![Ontology](https://imgur.com/zq7sMoY.png)


Para extraer los datos de una plataforma se debe seleccionar el endpoint de una entidad que utilice la herramienta de CKAN como el gobierno de Australia y colocarlo como se ejemplifica a continuación. 

![Main](https://imgur.com/ZaKNEnW.png)

El extractor recorre la estructura que se basa en Paquetes o Datasets que contienen uno o varios recursos en diferentes formatos de distribución. Para esto hace llamadas a la API mediante HTTP extrayendo el JSON resultante de cada uno como se ilustra en la siguiente imagen.

![Extractor](https://imgur.com/o2ipEf9.png)

Luego de extraer cata dataset con sus recursos la siguiente imagen muestra cómo se utiliza Jena para convertir esos datos en tripletas usando la ontología previamente mencionada.

![Jena](https://imgur.com/BHZ6o2H.png)
