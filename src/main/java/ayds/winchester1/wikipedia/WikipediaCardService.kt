package ayds.winchester1.wikipedia

interface WikipediaCardService {
    fun getCard(artistName: String?): WikipediaArtistInfo?
}