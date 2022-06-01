package ayds.winchester1.wikipedia

import ayds.winchester1.wikipedia.artistinfo.WikipediaArtistInfoInjector

object WikipediaInjector {
    val wikipediaCardService: WikipediaCardService = WikipediaArtistInfoInjector.wikipediaCardService
}