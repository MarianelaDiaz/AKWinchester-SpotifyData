package ayds.winchester1.wikipedia

interface WikipediaService {
    fun getArtistInfo(artistName: String?): WikipediaArtistInfo?
}