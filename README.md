# AKWinchester-WikipediaData

![Wikipedia-logo-es](https://user-images.githubusercontent.com/21269974/171480033-f02d6707-ef75-4be5-aa2a-19e396df08f4.png)

#### Instalación

Agregar el submódulo al proyecto:
git submodule add https://github.com/MarianelaDiaz/AKWinchester-WikipediaData.git libs/SpotifyData

Incluir las siguientes lineas de código en archivo settings.gradle del proyecto:

    include ':WikipediaData'
    project(':WikipediaData').projectDir = new File('libs/WikipediaData')

presionar en Sync Gradle ![image](https://user-images.githubusercontent.com/21269974/171478492-16a88eec-687c-4a67-af94-2ee660273617.png)

Agregar las siguiente dependencia al archivo build.gradle de la app.

    implementation project(":WikipediaData")
    
presionar en Sync Gradle ![image](https://user-images.githubusercontent.com/21269974/171478492-16a88eec-687c-4a67-af94-2ee660273617.png)

#### Descripción

Este módulo provee la función de obtener información sobre determinada artista por medio de la api ofrecida por Wikipedia.

#### Pasos para obtener una descripcion sobre un artista en Wikipedia:
* Obtener una instancia de wikipediaCardService, por medio del método WikipediaInjector:
    
        WikipediaInjector.wikipediaCardService

* Luego se invoca el método **getCard** a la instancia **wikipediaCardService**, suministrándole el nombre del artista.

        val wikipediaCard = wikipediaCardService.getCard(artistName)
       
* Se obtendrá un objeto de tipo WikipediaArtistInfo con la información del artista.

#### Edge cases:

Sin conexión: La consulta getCard(artistName) retorna nulo.
Sin resultado: La consulta getCard(artistName) retorna nulo.
