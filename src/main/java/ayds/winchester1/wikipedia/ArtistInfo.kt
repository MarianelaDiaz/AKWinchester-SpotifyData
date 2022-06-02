package ayds.winchester1.wikipedia

interface ArtistInfo {
    val description: String
    val infoURL: String
    val sourceLogoURL: String
}

data class WikipediaArtistInfo (
    override val description: String,
    override val infoURL: String,
    override val sourceLogoURL: String
) : ArtistInfo