package ayds.winchester1.spotify

import ayds.winchester1.spotify.artistinfo.WikipediaArtistInfoInjector

object WikipediaInjector {
    val wikipediaCardService: WikipediaCardService = WikipediaArtistInfoInjector.wikipediaCardService
}