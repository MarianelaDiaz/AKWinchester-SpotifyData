package ayds.winchester1.wikipedia

interface ArtistInfo {
    val description: String
    val infoURL: String
}

data class WikipediaArtistInfo (
    override val description: String,
    override val infoURL: String,
) : ArtistInfo