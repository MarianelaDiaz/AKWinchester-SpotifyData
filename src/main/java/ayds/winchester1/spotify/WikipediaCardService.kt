package ayds.winchester1.spotify

interface WikipediaCardService {
    fun getCard(artistName: String?): WikipediaCard?
}