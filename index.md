# Autores
- José Eduardo Eguiguren
- María José Mora

# Documentación
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

## Aplicación para consumir los datos extraídos
Las tripletas generadas por Jena son almacenadas en Openlink Virtuoso y se utiliza el SPARQL endpoint que provee para responder a ciertas preguntas planteadas. El buscador puede filtrar entre grupos, etiquetas y publishers de los datos y su interfaz es la siguiente:

![Interface](https://imgur.com/ksb84W9.png)

### Tags
La interfaz permite filtrar los catalogos según la etiqueta ingresada y buscará cualquier etiqueta que se asemeje a la consulta ingresada.
#### Búsqueda
![search tag](https://imgur.com/oCefERB.png)
#### Resultado
![search tag result](https://imgur.com/v8At31f.png)

### Groups
Los grupos tienen tres tipos de búsquedas diferentes. Primero se puede listar todos los grupos y sus catálogos correspondientes.
#### Búsqueda
![list groups](https://imgur.com/W8xHBUm.png)
#### Resultado
![list groups result](https://imgur.com/XovyFak.png)

También se puede buscar cuantos catálogos existen por cada grupo en los datos.
#### Búsqueda
![how many groups](https://imgur.com/3Rd2E8o.png)
#### Resultado
![how many groups result](https://imgur.com/Is59rhZ.png)

Finalmente se puede buscar que catálogos pertenecen al grupo que se ingresa en la búsqueda.
#### Búsqueda
![search groups](https://imgur.com/rWetgNC.png)
#### Resultado
![search groups result](https://imgur.com/z02FDDv.png)

### Publishers
El último filtro del buscador permite listar los editores de los catálogos que han sido publicados en caso de tenerlos.
#### Búsqueda
![publishers](https://imgur.com/SDEtHvL.png)
#### Resultado
![publishers result](https://imgur.com/ngOH7Cm.png)

### Sparql Endpoint Graph
También se ha implementado un generador de grafos a partir de una consulta SPARQL usando la librería de [d3sparql](https://github.com/ktym/d3sparql). A continuación se muestra un grafo con los catálogos asociados a sus etiquetas.
#### Búsqueda
![graph](https://imgur.com/i3mltM3.png)
#### Resultado
![graph result](https://imgur.com/dUzpwgM.png)
