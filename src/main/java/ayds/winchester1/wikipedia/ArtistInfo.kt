package ayds.winchester1.wikipedia

private const val NO_RESULTS = "No results"

interface ArtistInfo {
    val description: String
    val infoURL: String
    //val sourceLogoURL: String
}

data class WikipediaArtistInfo (
    override val description: String,
    override val infoURL: String,
    //override val sourceLogoURL: String
) : ArtistInfo