package ayds.winchester1.wikipedia

import ayds.winchester1.wikipedia.artistinfo.WikipediaArtistInfoInjector

object WikipediaInjector {
    val wikipediaService: WikipediaService = WikipediaArtistInfoInjector.wikipediaService
}